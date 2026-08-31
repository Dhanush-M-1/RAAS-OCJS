import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;


public class C
{
    BufferedReader in;
    PrintStream out;
    StringTokenizer tok;
    public C() throws NumberFormatException, IOException
    {
        in = new BufferedReader(new InputStreamReader(System.in));
        //in = new BufferedReader(new FileReader("in.txt"));
        out = System.out;
        run();
    }
    void run() throws NumberFormatException, IOException
    {
        int sizepersecond = nextInt();
        int speed = nextInt();
        int lenght = nextInt();
        for(int t = 0; true; t++)
        {
            if((lenght + t)*speed >= sizepersecond*lenght)
            {
                out.println(t);
                return;
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        new C();
    }
    String nextToken() throws IOException
    {
        if(tok == null || !tok.hasMoreTokens()) tok = new StringTokenizer(in.readLine());
        return tok.nextToken();
    }
    int nextInt() throws NumberFormatException, IOException
    {
        return Integer.parseInt(nextToken());
    }
    long nextLong() throws NumberFormatException, IOException
    {
        return Long.parseLong(nextToken());
    }
    double nextDouble() throws NumberFormatException, IOException
    {
        return Double.parseDouble(nextToken());
    }
}
