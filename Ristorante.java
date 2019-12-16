public class Ristorante
{
    
    private static void o (String s) {System.out.print (s);}
    private static void ol (String s) {System.out.println (s);}
    
    public static void main (String [] args) throws Exception
    {
        Ingrediente [] ingrediente = new Ingrediente [100];
        Input in = new Input (); 
        Output ou = new Output ();
        DataBase data = new DataBase ();
        Inserisci inserisci = new Inserisci ();
        Ricette ricette = new Ricette ();
        Tavoli tavoli = new Tavoli ();
        
        int scelta = 0;
        int totaleIngredienti = 0;
        boolean accessoAmministratori = false;
        boolean accessoClienti = false;
        boolean esci = false;
        
        
     do {
        ou.menùClienti (accessoAmministratori, accessoClienti);
        scelta = in.readInt ();
        
        if (accessoAmministratori == false && accessoClienti == false)
        {
            switch (scelta)
            {
                case 0 :
                   ol ("GRAZIE PER AVER USATO IL NOSTRO SOFTWEARE ");
                    esci = true;
                    break;
                    
                case 1 : 
                    accessoClienti = true;
                    break;
                
                case 2 : 
                     if (inserisci.controllaPassword () == true)
                     {
                         accessoAmministratori = true;
                     }
                     break;
            }
        }
        
        if (accessoAmministratori == true && accessoClienti == false)
        {
            switch (scelta)
            {
                case 0 :
                    accessoAmministratori = false;
                    break;
                    
                case 1 : 
                    ingrediente [totaleIngredienti] = new Ingrediente (inserisci.inserisciNome (),inserisci.inserisciQuantità ());
                    totaleIngredienti++;
                    break;
                
                case 2 : 
                    for (int i = 0; i < totaleIngredienti; i++)
                    {
                      ingrediente [i].getIngrediente ();
                    }
                    break;
                     
                case 3 :
                    data.inserisciRicetta (inserisci.passaNomeRicetta(), inserisci.passaQuantitàRicetta (), inserisci.passaIngredienti (), inserisci.passaQuantità()); 
                    break;
                    
                case 4 :
                    data.leggiRicetta ();
                    break;
            }
        }
        
        if (accessoAmministratori == false && accessoClienti == true)
        {
            switch (scelta)
            {
                case 0 :
                    accessoClienti= false;
                    break;
                    
                case 1 : 
                    tavoli.prenotaTavolo ();
                    break;
                
                case 2 : 
                    tavoli.disdiciTavolo();
                    break;
                     
                case 3 :
                    tavoli.vediTavoli();
                    break;
                    
                case 4 :
                    tavoli.ordina();
                    break;
            }
        }
        
    }while (esci == false);
  }   
}
