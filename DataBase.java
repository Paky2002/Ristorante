import java.io.*;

public class DataBase
{

  public DataBase () 
  {
 
  }
  
  public static void inserisciRicetta (String nome, int quantità, String [] nomi, int [] quantitàI) throws IOException {
        BufferedWriter file = null;
    try {
        file = new BufferedWriter(new FileWriter("ricette.txt", true));
        
        file.write("--- ");
        file.write(nome);
        file.write(" ---");
        
        for (int i = 0; i < quantità; i++)
        {
            file.write("\n" +nomi [i] +" " +quantitàI [i]);
        }
    } finally {
        if (file != null) {
            file.close();
        }
    }
  }
 
  public void leggiRicetta () throws IOException {
    FileReader f;
    f=new FileReader("ricette.txt");

    BufferedReader b;
    b=new BufferedReader(f);

    String s;

    while(true) {
      s=b.readLine();
      if(s==null)
        break;
      System.out.println(s);
    }
  }
  
  public static void inserisciIngrediente (String nome, int quantità, String [] nomi, int [] quantitàI) throws IOException {
        BufferedWriter file = null;
    try {
        file = new BufferedWriter(new FileWriter("ingredienti.txt")); //Non append
        
        file.write("--- ");
        file.write(nome);
        file.write(" ---");
        
        for (int i = 0; i < quantità; i++)
        {
            file.write("\n" +nomi [i] +" " +quantitàI [i]);
        }
        
    } finally {
        if (file != null) {
            file.close();
        }
    }
  }
  
  public void leggiIngrediente () throws IOException {
    FileReader f;
    f=new FileReader("ricette.txt");

    BufferedReader b;
    b=new BufferedReader(f);

    String s;

    while(true) {
      s=b.readLine();
      if(s==null)
        break;
      System.out.println(s);
    }
  }
  
  public void varia (String ordinato) throws IOException {
    FileReader f;
    f=new FileReader("ricette.txt");
    
    String finale = ("--- " +ordinato +" ---");
    
    BufferedReader b;
    b=new BufferedReader(f);

    String s;

    while(true) {
      s=b.readLine();
      if(s==null)
      {
        break;
      }
      else
      {
          if (finale.equals(s))
          {
              System.out.println ("TROVATO");
              s=b.readLine(); //Passiamo nome Ingrediente
              controllaSeCe (s);
              System.out.println(s);
              s=b.readLine();
              System.out.println(s);
          }
      }
    }
  }
  
  public void controllaSeCe (String ordinato) throws IOException 
  {
      
  
  }
}



