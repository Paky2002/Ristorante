public class Estrazione extends Ridotto
{
    public int [] estrattiCasuale = new int [6];
    
    
    private static void ol (String s) {System.out.println (s);}
    private static void o (String s) {System.out.print (s);}
    public Estrazione(int numeriGiocati [], int totale, int garanzia)
    {
        super (numeriGiocati, totale, garanzia);
        estrazione ();
        vediEstratti ();
        controlloIntegrale ();
    }

    public void  estrazione ()
    {
        int temp;
        for (int i = 0; i < 6; i++)
        {
            do {
                temp = (int) (Math.random () * (90));
            }while (controlli (temp, i) != true);
            estrattiCasuale [i] = temp;
        }
      
    }
    
    public void vediEstratti ()
    {
        o("NUMERI ESTRATTI ==>" +"\t");
        for (int i = 0; i < 6; i++)
        {
            o(+estrattiCasuale [i] +"\t");
        }
        o("\n");
    }
    
    public boolean controlli (int temp, int indice)
    {
        for (int i = 0; i < indice; i++)
        {
            if (estrattiCasuale [i] == temp)
            {
                return false;
            }
        }
        return true;
    }
    
    public void controlloIntegrale ()
    {
        int conta = 0;
        int o = 0;
        for (int p = 0; p < calcolaRighe () ; p++)
        {
            conta = 0;
            for (int j = 0; j < 6; j++)
            {
                for (int i = 0; i < 6; i++)
                {
                    if (integrale [p] [j] == estrattiCasuale [i])
                    {
                        conta ++;
                    }
                }
            }
            if (conta == 3)
            {
                o("HAI FATTO 3 ALLA SESTINA NUMERO " +(p+1) + " =>  \t");
                for (int k = 0; k < 6; k++)
                {
                    o(+integrale [p] [k] + "\t");
                }
                ol("");
            }
            
            if (conta == 4)
            {
                o("HAI FATTO 4 ALLA SESTINA NUMERO " +(p+1) + " =>  \t");
                for (int k = 0; k < 6; k++)
                {
                    o(+integrale [p] [k] + "\t");
                }
                ol("");
            }
            
            if (conta == 5)
            {
                o("HAI FATTO 5 ALLA SESTINA NUMERO " +(p+1) + " =>  \t");
                for (int k = 0; k < 6; k++)
                {
                    o(+integrale [p] [k] + "\t");
                }
                ol("");
            }
            
            if (conta == 6)
            {
                o("HAI FATTO 6 ALLA SESTINA NUMERO " +(p+1) + " =>  \t");
                for (int k = 0; k < 6; k++)
                {
                    o(+integrale [p] [k] + "\t");
                }
                ol("");
            }
        }    
    }
    
    
}
