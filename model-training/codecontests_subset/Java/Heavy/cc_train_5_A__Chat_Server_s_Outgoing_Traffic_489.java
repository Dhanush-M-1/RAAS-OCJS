import java.io.*;
import java.math.*;
import java.util.*;

public class Main
{
    public static void main(String args[]) throws IOException
    {
        new Main().run();
    }
    BufferedReader in;
    PrintWriter out;
    public void run() throws IOException
    {
        in =new BufferedReader(new InputStreamReader(System.in));
          out = new PrintWriter(new OutputStreamWriter(System.out));
       /* out = new PrintWriter(new FileWriter("output.txt"));
        in =new BufferedReader(new FileReader("input.txt"));*/

        solve();

        out.flush();
    }

   /* public int nextInt() throws IOException
    {
        in.nextToken();
        return (int)in.nval;
    }*/
    public void solve() throws IOException
    {
        int k=0,answ=0;
        while(true)
        {
        	String a=in.readLine();
        	if(a==null)
        	{
        		out.print(answ);
        		return;
        	}
        	if(a.charAt(0)=='+')
        		k++;
        	else
        		if(a.charAt(0)=='-')
        			k--;
        		else
        		{
        			int n=a.length();
        			int i=0;
        			while(a.charAt(i)!=':')
        				i++;
        			answ+=(n-i-1)*k;
        		}
        }
        
    }

}