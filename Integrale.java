import java.io.*; 
public class Integrale
{
    // variabili d'istanza - sostituisci l'esempio che segue con il tuo
    final int DIMMAX = 1000;
    final int k = 6;    //6 numero fisso per le sestine
    final int fSei = 720;
    public int [] numeriGiocati = new int [90];    //NUMERI GIOCATI es.1-11-34-54...
    private int [] [] colonne = new int [DIMMAX] [6];
    public int totale;
    
    public Integrale(int numeriGiocati [], int totale)
    {
        this.totale = totale;
        this.numeriGiocati = numeriGiocati;
        creaColonne();       
    }

    public int calcolaRighe () //Fattoriale di Tot Numeri Giocata
    {   
       int fatt = 1, ng=1, NumRighe;  //<fatt> - serve a fare il Fattoriale di 'totale' | <ng> - come var di appoggio per vedere n righe
        for (int i = 2; i <= totale; i++)
       {
           fatt = fatt * i;
       }
       
       for (int i = 2; i <= totale-k; i++)
       {
           ng = ng * i;
       }
       
       NumRighe = (fatt/ng)/fSei; //720 fattoriale di 6 (!6)
       return NumRighe;
    }
    
    public int [] [] creaColonne () //crea Sistema Integrale (tabella)
    {
        int T = totale - k;     //Num. fisso per Sistema Integrale
        int u = 0;
          
            for(int i = 0; i<= T;i++){                
                for(int j = i+1; j<= T+1;j++){           
                    for(int g = j+1; g<= T+2;g++){                        
                        for(int x = g+1; x<= T+3;x++){                           
                            for(int y = x+1; y<= T+4;y++){                                
                                for(int z = y+1; z<= T+5;z++){                                  
                                    colonne [u] [0] = numeriGiocati[i];
                                    colonne [u] [1] = numeriGiocati[j];
                                    colonne [u] [2] = numeriGiocati[g];
                                    colonne [u] [3] = numeriGiocati[x];
                                    colonne [u] [4] = numeriGiocati[y];
                                    colonne [u] [5] = numeriGiocati[z];
                                    u++;
                                }
                            }
                        }
                    }
                }
            }
            
        return colonne;
    }
    
    public int [] [] getIntegrale () {return colonne;}
    
    public void guardaIntegrale ()
    {
    for(int i = 0; i<calcolaRighe();i++){
            System.out.print("SESTINA NUMERO " +(i+1) + " =>  \t");
            for(int j = 0;j<6;j++){
            System.out.print(colonne[i][j]+" \t");
            }
            System.out.print("\n");
        }
    }
}
