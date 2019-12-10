import java.io.*;
public class Enalotto 
{
    private static void ol (String s) {System.out.println (s);}
    private static void o (String s) {System.out.print (s);}
    public static void main (String args []) throws Exception
    {
        Input in = new Input ();
        Inserisci inserisci = new Inserisci (); //Creazione dell'oggetto che decreta l'inserimento
        final int DIMMAX = 90; //Massimo di numeri giocabili
        int contatoreMenù = 0;
        
        
        int scelta = 0; //Scelta per il menù  
        
        do{
            ol("#####################################");
            ol("######     MENU'               ######");
            ol("# 0) ESCI                           #"); 
            ol("# 1) INSERISCI I NUMERI             #");
            
            if (contatoreMenù > 0)
            {
                ol("# 2) VISUALIZZA IL SISTEMA INTEGRALE #");
                if (inserisci.getTotale () >= 10)
                {
                    ol("# 3) VISUALIZZA IL SISTEMA RIDOTTO   #");
                    ol("# 4) TESTA IL SISTEMA RIDOTTO        #");
                    ol("# 5) ESTRAZIONE                      #");
                }
                else
                {
                    ol(" 3) ESTRAZIONE                      #");
                }
                
            }
            ol("#####################################");
            scelta = in.readInt();
            
            switch (scelta)
            {
                case 0 : 
                    o("GRAZIE PER AVER USATO IL MIO SOFTWARE, ciao");           
                    break;
                   
                case 1 :  
                    inserisci.inserisci ();
                    inserisci.verificabilità();
                    contatoreMenù++; 
                    break;
                    
            }  
            
            if (contatoreMenù > 0 && inserisci.getTotale () < 10)
            {
                switch (scelta)
                    {
                        case 2 :  
                            Integrale integrale = new Integrale (inserisci.getNumeri (), inserisci.getTotale ());
                            integrale.guardaIntegrale();
                            break;
                            
                        case 3 :
                             Estrazione estrazione = new Estrazione (inserisci.getNumeri (), inserisci.getTotale (), inserisci.verificabilità ());
                             break;
                    }
            }
            
            if (contatoreMenù > 0 && inserisci.getTotale () >= 10)
            {
                switch (scelta)
                {
                    case 2 :  
                        Integrale integrale = new Integrale (inserisci.getNumeri (), inserisci.getTotale ());
                        integrale.guardaIntegrale();
                        break;
                    
                    case 3 : 
                        Ridotto ridotto = new Ridotto (inserisci.getNumeri (), inserisci.getTotale (), inserisci.verificabilità ());
                        ridotto.vediRidotto ();
                        break;
                        
                    case 4 :
                        Test test = new Test (inserisci.getNumeri (), inserisci.getTotale (), inserisci.verificabilità ());
                        break;
                        
                    case 5 :
                        Estrazione estrazione = new Estrazione (inserisci.getNumeri (), inserisci.getTotale (), inserisci.verificabilità ());
                        break;
                }
            }
        }while (scelta != 0);
    }
    
    public static void cls() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
}

}
