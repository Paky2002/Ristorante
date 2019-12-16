public class Inserisci
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    public String password = ("risto");
    public int quantiIngredienti = 0;
    public int [] quantitàIngredienti = new int [100];
    public String [] unitàDiMisura = new String [100];
    Input in = new Input ();
    public String nome;
    
    public Inserisci ()
    {
   
    }

    private static void o (String s) {System.out.print (s);}
    private static void ol (String s) {System.out.println (s);}
    
    public boolean controllaPassword () throws Exception
    {
        // metti qui il tuo codice
        String pass;
        o ("INSERISCI LA PASSWORD : ");
        pass = in.readString ();
        
        if (pass.equals(password))
        {
            ol ("PASSWORD GIUSTA ! ");
            return true;
        }
        
        ol ("PASSWORD ERRATA ! ");
        return false;
    }
    
    public String passaNomeRicetta () throws Exception
    {
        String nome;
        
        ol ("COME SI CHIAMA QUESTA RICETTA ? ");
        nome = in.readString ();
        
        return nome;
    }
    
    public int passaQuantitàRicetta () throws Exception
    {   
        ol ("QUANTI INGREDIENTI CI SONO ? ");
        quantiIngredienti = in.readInt ();
   
        return quantiIngredienti;
    }
    
    public String [] passaIngredienti () throws Exception
    {
        String [] Ingredienti = new String [100];
        ol ("ff" +quantiIngredienti);
        
        for (int i = 0; i < quantiIngredienti; i++)
        {
            ol ("INSERISCI IL NOME DELL'INGREDIENTE NUMERO " +(i+1));
            Ingredienti [i] = in.readString ();
            ol ("INSERISCI LA QUANTITA' DI " +Ingredienti [i]);
            quantitàIngredienti [i] = in.readInt ();
            controlloUnità (i);
       }
       
       return Ingredienti;
    }
    
    
    public int [] passaQuantità () 
    {
        return quantitàIngredienti;
    }
    
    public String [] passaUnità ()
    {
        return unitàDiMisura;
    }
    
    
    public void controlloUnità (int Indice) throws Exception
    {
        int scelta;
        
        do{
            ol ("INSERISCI L' UNITA' DI MISURA ");
            
            ol ("1) GRAMMI ");
            ol ("2) MILLILITRI ");
            
            scelta = in.readInt ();
            
            switch (scelta)
            {
                case 1 : 
                     unitàDiMisura [Indice] = "Gr";
                     break;
                     
                case 2 :
                     unitàDiMisura [Indice] = "Ml";
                     break;
            }
            
        }while (scelta > 2);
    }
    
    public int controlloDisponibilità (int tav2, int tav4, int tav6, int temp)
    {
        if (temp == 2)
        {
            if (tav2 > 0)
            {
                return 1;
            }
            else
            {
                ol ("NON DISPONIBILE ");
                return 0;
            }
        }
        
        if (temp == 4)
        {
            if (tav4 > 0)
            {
                return 1;
            }
            else
            {
                ol ("NON DISPONIBILE ");
                return 0;
            }
        }
        
        if (temp == 6)
        {
            if (tav6 > 0)
            {
                return 1;
            }
            else
            {
                ol ("NON DISPONIBILE ");
                return 0;
            }
        }
        
        ol ("NON DISPONIBILE ");
        return 0;
    }
    
    public int controlloNome (String nomeInserito, String [] totaleNomi, int totaleTavoli)
    {
        int indice = 0;
        
        for (int i = 0; i < totaleTavoli; i++)
        {
            if (nomeInserito.equals(totaleNomi [i]))
            {
                return i;
            }
        }
        
        ol ("NOME NON TROVATO, NESSUNA CORRISPONDENZA");
        return 0;
    }
    
    public String inserisciNome () throws Exception
    {    
        ol ("INSERISCI NOME INGREDIENTE : ");
        nome = in.readString ();
        
        return nome;
    }
    
    public int inserisciQuantità () throws Exception
    {
        int quantità;
        
        ol ("INSERISCI QUANTITA' DI " +nome);
        quantità = in.readInt ();
        
        return quantità;
    }
    
    
}
