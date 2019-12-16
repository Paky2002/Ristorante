public class Output
{

    private static void o (String s) {System.out.print (s);}
    private static void ol (String s) {System.out.println (s);}
    
    public void menùClienti (boolean accessoAmministratori, boolean accessoClienti)
    {
        if (accessoAmministratori == false && accessoClienti == false)
        {
            ol ("---MENU' RISTO CARPINO---");
            ol ("0) ESCI ");
            ol ("1) ACCEDI COME CLIENTE");
            ol ("2) ACCEDI COME AMMINISTRATORE");
        }
        
        if (accessoAmministratori == true && accessoClienti == false)
        {
            ol ("---MENU' RISTO CARPINO---");
            ol ("0) TORNA AL MENU' PRINCIPALE");
            ol ("1) COMPRA INGREDIENTI ");
            ol ("2) VISUALIZZA INGRDEIENTI ");
            ol ("3) AGGIUNGI RICETTA "); 
            ol ("4) GUARDA LE RICETTE "); 
        }
        
        if (accessoAmministratori == false && accessoClienti == true)
        {
            ol ("---MENU' RISTO CARPINO---");
            ol ("0) TORNA AL MENU' PRINCIPALE");
            ol ("1) PRENOTA TAVOLO ");
            ol ("2) DISDICI TAVOLO "); 
            ol ("3) ORDINA");
        }
        
    }
}
