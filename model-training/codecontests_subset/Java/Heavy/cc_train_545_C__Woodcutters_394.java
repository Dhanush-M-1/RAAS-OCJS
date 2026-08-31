import java.io.*;
import java.util.*;
public class codedp5
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int x[]=new int[n];
        int h[]=new int[n];
        for(int i=0;i<n;i++)
        {
            String s[]=br.readLine().trim().split(" ");
            x[i]=Integer.parseInt(s[0]);
            h[i]=Integer.parseInt(s[1]);
        }
        int c=1;int prev=x[0];
        for(int i=1;i<n-1;i++)
        {
            if(x[i]-h[i] > prev)
            {
                prev=x[i];
                c++;
            }
            else if(x[i]+h[i] < x[i+1])
            {
                prev=x[i]+h[i];
                c++;
            }
            else
            {
                prev=x[i];
            }
        }
        if(n>1)
        {
            c++;
        }
        System.out.println(c);
    }
}