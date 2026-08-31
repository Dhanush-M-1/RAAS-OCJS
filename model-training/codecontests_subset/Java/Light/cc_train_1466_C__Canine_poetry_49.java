import java.util.*;
import java.io.*;
import java.awt.*;

public class CaninePoetry
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int t = Integer.parseInt(f.readLine());
        for (int K=0; K<t; K++)
        {
            StringBuilder str = new StringBuilder(f.readLine());
            int len = str.length();
            int[] s = new int[len];
            for (int i=0; i<len; i++)
            {
                s[i] = str.charAt(i)-'a';
            }
            int count = 0;
            boolean[] c = new boolean[len];
            if (len>1 && s[0]==s[1])
            {
                c[1] =true;
                count++;
            }

            for (int i=1; i<len-1; i++)
            {
                if (!c[i]&& s[i]==s[i+1])
                {
                    c[i+1] = true;
                    count++;
                }
                if (!c[i-1] && s[i-1]==s[i+1])
                {
                    c[i+1] = true;
                    count++;
                }
            }
            out.println(count);

        }
        out.close();
    }
}
