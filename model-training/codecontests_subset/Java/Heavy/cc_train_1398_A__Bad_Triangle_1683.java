// This code will help stdnoob to become red coder on codeforces //
import java.util.*;
import java.io.*;
import java.lang.*;
public class codeforces
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while(t-- != 0)
        {
            int n = Integer.parseInt(br.readLine());
            String s1[]=(br.readLine()).split(" ");
            int a[] = new int[n];
            for(int i=0;i<n;i++)
            a[i] = Integer.parseInt(s1[i]);
            int sum = a[0]+a[1];
            boolean flag = true;
            for(int i=2;i<n;i++)
            {
                if(a[i]>=sum)
                {
                    pw.println("1 2 "+(i+1));
                    flag = false;
                    break;
                }
            }
            if(flag)
            pw.println("-1");
        }
        pw.flush();       
    }
}