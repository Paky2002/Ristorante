import java.io.*;
public class Test extends Ridotto
{
    private int [] test = new int [totale];
    private int [] estratti = new int [6];
    private int [] [] testati = new int [DIMMAX] [6];
    
    
    private static void ol (String s) {System.out.println (s);}
    private static void o (String s) {System.out.print (s);}
    public Test(int numeriGiocati [], int totale, int garanzia)
    {
        super (numeriGiocati, totale, garanzia);
        Estrattore ();
        vediEstratti();
        vediColonne();
    }

    public void Estrattore ()
    {
        int temp;
        for (int i = 0; i < 6; i++)
        {
            do {
                temp = (int) (Math.random () * (totale-1));
            }while (controlli (temp, i) != true);
            estratti [i] = temp;
        }
    }
    
    public boolean controlli (int temp, int indice)
    {
        for (int i = 0; i < indice; i++)
        {
            if (estratti [i] == temp)
            {
                return false;
            }
        }
        return true;
    }
    
    public void vediEstratti ()
    {
        o("NUMERI ESTRATTI ==>" +"\t");
        for (int i = 0; i < 6; i++)
        {
            o(+numeriGiocati [estratti [i]] +"\t");
        }
        o("\n");
    }
    
    public void vediColonne ()
    {
        int conta = 0;
        int o = 0;
        for (int p = 0; p < cRidotto; p++)
        {
            conta = 0;
            for (int j = 0; j < 6; j++)
            {
                for (int i = 0; i < 6; i++)
                {
                    if (ridotto [p] [j] == numeriGiocati[estratti [i]])
                    {
                        conta ++;
                    }
                }
            }
            if (conta == garanzia)
            {
                o("SESTINA RIDOTTA NUMERO " +(p+1) + " =>  \t");
                for (int k = 0; k < 6; k++)
                {
                    o(+ridotto [p] [k] + "\t");
                }
                ol("");
            }
        }    
    }
}
