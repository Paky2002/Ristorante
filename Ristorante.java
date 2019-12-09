public class Ristorante
{
    private static void o (String s) {System.out.print (s);}
    private static void ol (String s) {System.out.println (s);}
    
    public static void main (String [] args) throws Exception
    {
        Ingrediente [] ingrediente = new Ingrediente [100];
        Input in = new Input (); 
        Output ou = new Output ();
        Controlli controlli = new Controlli ();
        Ricette [] ricette = new Ricette [100];
        
        int scelta = 0;
        int totaleRicette = 0;
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
                    break;
                    
                case 1 : 
                    break;
                
                case 2 : 
                     if (controlli.controllaPassword () == true)
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
                    ingrediente [totaleIngredienti] = new Ingrediente ();
                    ingrediente [totaleIngredienti] .compraIngrediente ();
                    totaleIngredienti++;
                    break;
                
                case 2 : 
                    for (int i = 0; i < totaleIngredienti; i++)
                    {
                      ingrediente [i].getIngrediente ();
                    }
                    break;
                     
                case 3 :
                    ricette [totaleRicette] = new Ricette ();
                    ricette [totaleRicette].aggiungiRicetta ();
                    totaleRicette++;
                    break;
                    
                case 4 :
                    for (int i = 0; i < totaleRicette; i++)
                    {
                        ricette [i].getRicette ();
                    }
            }
        }
        
    }while (esci == false);
  }   
}
