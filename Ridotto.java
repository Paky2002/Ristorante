import java.io.*;
public class Ridotto extends Integrale
{
    final int DIMMAX = 1000;
    public int garanzia = 0;
    public int [] [] integrale = new int [DIMMAX] [6];
    public int [] [] ridotto = new int [DIMMAX] [6];
    public int cRidotto = 0;

    
    public Ridotto(int numeriGiocati [], int totale, int garanzia)
    {
        super (numeriGiocati, totale);
        integrale = creaColonne ();
        this.garanzia = garanzia;
        riduci ();
    }
    
    public void riduci()
    {
        cRidotto = 0;
        int temp = 0;
        
        for (int i = 0; i < calcolaRighe (); i++)
        {
            temp = controllo (i, cRidotto);
            if (temp > 0)
            {
                cRidotto++;
                i = temp;
            }     
        }
    }
    
    public int controllo (int indice, int c)
    {
        int conta = 0;
        int [] [] confronta = new int [DIMMAX] [6]; 
        
        if (indice == 0)
        {
            for (int p = 0; p < 6; p++)
            {
                confronta [0][p] = integrale [0] [p];
            }
            
            for (int i = 0; i < calcolaRighe(); i++)
            {
                conta = 0;
                for (int k = 0; k < 6; k++)
                {
                    for (int j = 0; j < 6; j++ )
                    {
                        if (confronta [0][k] == integrale [i] [j])
                        {
                            conta++;
                        }
                    }
                }
                
                if (conta == garanzia - 1)
                {
                    for (int o = 0; o < 6; o++)
                    {
                        ridotto [0] [o] = integrale [i] [o];
                    }
                    return i;
                }
            }   
        }
        else
        {
            for (int i = indice; i < calcolaRighe(); i++)
            {
                conta = 0;
                for (int k = 0; k < 6; k++)
                {
                    for (int j = 0; j < 6; j++ )
                    {
                        if (ridotto [cRidotto-1][k] == integrale [i] [j])
                        {
                            conta++;
                        }
                    }
                }
                if (conta == garanzia - 1)
                {
                    for (int o = 0; o < 6; o++)
                    {
                        ridotto [c] [o] = integrale [i] [o];
                    }
                    return i;
                }
            }   
        }
        
        return -1;      
    }
    
    public void vediRidotto ()
    {
        System.out.println ("*GARANZIA GIOCATA ==> " +garanzia);
        System.out.println ("#### SISTEMA RIDOTTO ####\n");
        
        for (int i = 0; i < cRidotto; i++)
        {
            System.out.print ("SESTINA NUMERO " +(i+1) + " =>  \t"); 
            for (int j = 0; j < 6; j++)
            {
                System.out.print (+ridotto [i] [j] + "\t");    
            }
            System.out.print("\n");
        }
    }
}
