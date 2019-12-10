import java.io.*;
public class Inserisci
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    final int DIMMAX = 90; //Massimo de numeri da poter giocare
    private int [] numeriGiocati = new int [DIMMAX];
    private int totale = 0;
    private int garanzia = 0;
    
    
    Input in = new Input ();
    
    private static void ol (String s) {System.out.println (s);}
    private static void o (String s) {System.out.print (s);}
    public Inserisci()
    {
        verificabilità();
    }

    public void inserisci () throws Exception //Metodo per inserire il tutto
    {   
        do{
        ol ("QUANTI NUMERI VUOI INSERIRE ? ");
        totale = in.readInt(); //Inserimento del totale
            if(totale < 6 || totale > 90)
                ol("**PUOI INSERIRE MINIMO 6 NUMERI**");
        }while(totale < 6 || totale > 90);
        
        ol("INSERISCI I NUMERI : ");
        for (int i = 0; i < totale; i++)
        {
            do{
            o(i+1 + "- NUMERO ==> ");
            numeriGiocati [i] = in.readInt();
        }while (controllo (i,numeriGiocati [i]) == true); //Condizione condizionata dai controlli
        }
    }
    
    public boolean controllo (int indice, int temp ) //Metodo che controlla ogni numero immesso
    {
        if (temp <= 0 || temp > 90) //Controllo se è minore o maggiore di 90/0
        {
            ol("**INSERISCI UN NUMERO COMPRESO TRA 1 - 90**");
            return true;
        }
        
        for (int i = 0; i < indice; i++) //Controllo se è un numero già stato immesso
        {
            if (temp == numeriGiocati [i])
            {
                ol("**ATTENZIONE NUMERO GIA' IMMESSO**");
                return true;
            }
        }
        
        return false; //Se passa i controlli il numero sarà ritenuto valido
    }
    
    public int verificabilità ()
    {
        if (totale >= 10 && totale < 33)
        {
            garanzia = inserisciGaranzia ();
            return garanzia;
        }
        else
        {
            ol("PER EFFETTUARE UN SISTEMA RIDOTTO BOSOGNA AVERE ALMENO 10 NUMERI");
            garanzia = -1;  
            return -1;
        }
    }
    
    public int inserisciGaranzia ()
    {  
        if(totale > 12 && totale < 20)
        {
            return 4;
        }
        
        if (totale > 19 && totale < 33)
        {
            return 3;
        }
        
        return 5;
    }
    
    public int[]  getNumeri () {return numeriGiocati;} //Funzione che ritorna il vettore dei numeri giocati
    public int getTotale () {return totale;} // Funzione che ritorna il totale
    public int getGaranzia () {return garanzia;}
} 
