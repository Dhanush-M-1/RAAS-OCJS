import java.io.*;
import java.util.*;

public class A
{
    Scanner in;
    PrintWriter out;

    void run() throws Exception
    {
        in = new Scanner(System.in);
        out = new PrintWriter(new OutputStreamWriter(System.out));
        solve();
        out.flush();
    }

    public static void main(String[] args) throws Exception
    {
        new A().run();
    }

    void solve() throws Exception
    {
        int num = 0;
        long traffic = 0;
        while(in.hasNextLine())
        {
            String s = in.nextLine();
            if(s.charAt(0)=='+')
                num++;
            else if (s.charAt(0)=='-')
                num--;
            else
            {
                int i = s.indexOf(':');
                s = s.substring(i+1);
                traffic += (num*s.length());
            }
        }
        out.println(traffic);
    }

   

   
}
