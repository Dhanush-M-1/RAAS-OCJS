import java.io.*;
import java.util.*;
public class Main
{
        static Scanner in = new Scanner(System.in);
        static PrintWriter out = new PrintWriter(System.out);
        //Scanner scanner = new Scanner(new BufferedReader(new FileReader("input.txt")));
        //PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
      /*static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        static int nextInt() throws IOException
        {
            in.nextToken();
            return (int) in.nval;
        }
        static double nextDouble() throws IOException
        {
            in.nextToken();
            return (double) in.nval;
        }
        */
    public static void main(String[] args) throws IOException
    {
        int[] a = new int[5];
        int sum = 0;
        for(int i = 0; i < 5; i++)
        {
            a[i] = in.nextInt();
            sum += a[i];
        }
        if(sum % 5 == 0 && sum >= 5)
            out.println(sum / 5);
        else
            out.println(-1);
        
        out.flush();
    }
}
/*
2 5 4 0 4
3

4 5 9 2 1
-1
*/


























