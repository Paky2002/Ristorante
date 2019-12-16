public class Ingrediente
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    private int quantità;
    private int unitàDiMisura;
    private String nome;

    private static void o (String s) {System.out.print (s);}
    private static void ol (String s) {System.out.println (s);}
    
    Input in = new Input ();
    
    public Ingrediente (String nome, int quantità)
    {
        this.nome = nome;
        this.quantità = quantità;
    }

    public void modificaQuantità (int variazione)
    {
        quantità -= variazione; 
    }
    
    public String getNome () {return nome;}
    public int getQuantità () {return quantità;}
   
    public void getIngrediente ()
    {
        o("---" +nome);
        o(" " +quantità);
    }
}
