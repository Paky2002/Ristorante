import java.io.*;

public class Input
{
    BufferedReader reader;
    
    public Input ()
    {
        reader = new BufferedReader (new InputStreamReader(System.in));
    }
    
    public int readInt () throws Exception
    {
        return Integer.parseInt(reader.readLine ());
    }
    
    public double readDouble () throws Exception
    {
        return Double.parseDouble(reader.readLine ());
    }
    
    public String readString () throws Exception
    {
        return reader.readLine();
    }
}