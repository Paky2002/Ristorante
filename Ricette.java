public class Ricette
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private String nome;
    private int quantiIngredienti = 0;
    private int [] quantitàIngredienti = new int [100];
    private String [] ingredienti = new String [100];
    private int [] unitàDiMisura = new int [100];
    
    private static void o (String s) {System.out.print (s);}
    private static void ol (String s) {System.out.println (s);}
    
    Input in = new Input ();
    
    public Ricette()
    {
  
    }

    public void aggiungiRicetta () throws Exception
    {
        ol ("COME SI CHIAMA QUESTA RICETTA ? ");
        nome = in.readString ();
        
        ol ("QUANTI INGREDIENTI CI SONO ? ");
        quantiIngredienti = in.readInt ();
        
        for (int i = 0; i < quantiIngredienti; i++)
        {
            ol ("INSERISCI IL NOME DELL'INGREDIENTE NUMERO " +(i+1));
            ingredienti [i] = in.readString ();
            ol ("INSERISCI LA QUANTITA' DI " +ingredienti [i]);
            quantitàIngredienti [i] = in.readInt ();
            controlloUnità (i);
       }
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
                     unitàDiMisura [Indice] = 1;
                     break;
                     
                case 2 :
                     unitàDiMisura [Indice] = 2;
                     break;
            }
            
        }while (scelta > 2);
    }
    
    public void getRicette ()
    {
            ol ("--- " +nome +" ---");
            ol ("NUMERO INGREDENTI : " +quantiIngredienti +"\n");
            for (int i = 0; i < quantiIngredienti; i++)
            {
                ol ("---> " +ingredienti [i]); 
                controlloConversione (i);
            }
            
    }
    
    public void controlloConversione (int indice)
    {
        double converti;
        
        if (quantitàIngredienti [indice] >= 1000)
        {
            converti = quantitàIngredienti [indice] / 1000;
            o (" " +converti +" ");
            switch (unitàDiMisura [indice]) 
            {
                case 1 :
                    o("Kg");
                    break;
                
                case 2:
                    o ("L");  
                    break;
            }
            return;
        }
        
        o (" " +quantitàIngredienti [indice] +" ");
        
        switch (unitàDiMisura [indice])
           {
               case 1 :
                   o("Gr");
                   break;
                
               case 2:
                   o ("Ml"); 
                   break;
           } 
        
    }
}
