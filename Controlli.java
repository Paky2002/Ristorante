public class Controlli 
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    public String password = ("risto");
    Input in = new Input ();
    
    public Controlli()
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
}
