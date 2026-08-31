import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        /*int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(br.readLine());
            String str[]=br.readLine().split(" ");
            int n=Integer.parseInt(str[0]);
            int k=Integer.parseInt(str[1]);
            str=br.readLine().split(" ")
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(str[i]);
        }*/
        String str[]=br.readLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int x=Integer.parseInt(str[1]);
        int y=Integer.parseInt(str[2]);
        char carr[]=br.readLine().toCharArray();
        int moves=0;
        for(int i=n-1;i>=n-x;i--)
        {
            if(i==n-y-1)
            {
                if(carr[i]!='1')
                moves++;
            }
            else
            {
                if(carr[i]=='1')
                moves++;
            }
        }
        pw.println(moves);
        pw.flush();
        pw.close();
    }
}