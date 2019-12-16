public class Tavoli 
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private int tavoli2 = 4;
    private int tavoli4 = 4;
    private int tavoli6 = 2;
    private String [] nomeTavolo = new String [9];
    private int [] persone = new int [9];
    private int totaleTavoli = 0;
    
    private static void o (String s) {System.out.print (s);}
    private static void ol (String s) {System.out.println (s);}
    
    Input in = new Input ();
    Inserisci inserisci = new Inserisci ();
    DataBase data = new DataBase ();
    
    public Tavoli()
    {
       
    }
    
    public void prenotaTavolo () throws Exception
    {
        int temp;
        
        ol ("QUANTI SIETE ? ");
        temp = in.readInt ();
        
        if (inserisci.controlloDisponibilità (tavoli2, tavoli4, tavoli6, temp) > 0)
        {
            switch (temp)
            {
                case 2 :
                    tavoli2--;
                    persone [totaleTavoli] = temp;
                    ol ("" +tavoli2);
                    break;
                    
                case 4 :
                    tavoli4--;
                    persone [totaleTavoli] = temp;
                    break;
                    
                case 6 :
                    tavoli6--;
                    persone [totaleTavoli] = temp;
                    break;
            }
            
            ol ("A NOME DI CHI PRENOTO ? ");
            nomeTavolo [totaleTavoli] = in.readString ();
            totaleTavoli++;
        }
    }
    
    public void disdiciTavolo () throws Exception
    {
        String temp;
        int disdetto = 0;
        
        ol ("A NOME DI CHI DISDICO ? ");
        temp = in.readString ();
        
        disdetto = inserisci.controlloNome (temp, nomeTavolo, totaleTavoli);
        ol("" +disdetto);
        
        if ((disdetto +1) > 0)
        {
             
             ol("" +persone [disdetto]);
             switch (persone [disdetto])
             {
                 case 2 :
                    tavoli2++;
                    break;
                    
                 case 4 :   
                    tavoli4++;
                    break;
                    
                 case 6 :
                    tavoli6++;
                    break;
             }
             
             for (int i = disdetto; i < totaleTavoli-1; i++)
             {
                 nomeTavolo [i] = nomeTavolo [i+1];
                 persone [i] = persone [i+1];
                 
             }
             
             totaleTavoli--;
        }
    }
    
    public void vediTavoli () throws Exception
    {
           for (int i = 0; i < totaleTavoli; i++)
           {
               ol("TAVOLO A NOME DI " +nomeTavolo [i] +" E PRENOTATI " +persone [i] +"POSTI");
           }
        
    }
    
    public void ordina () throws Exception
    {
        String ordinato;
        
        
        
        o("QUALE RICETTA VUOI ORDINARE ?");
        ordinato = in.readString ();
        data.varia(ordinato);
        
    }
    
    
    
}
