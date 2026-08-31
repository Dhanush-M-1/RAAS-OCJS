import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(bu.readLine());
        int i,c[]=new int[12];
        String s[]=bu.readLine().split(" ");
        for(i=0;i<n;i++)
        c[s[i].length()]++;

        long p[]=new long[25],M=998244353;
        p[0]=1;
        for(i=1;i<25;i++)
        p[i]=p[i-1]*10%M;

        long ans=0;
        for(i=0;i<n;i++)
        {
            int j,u;
            for(j=s[i].length()-1,u=0;j>=0;j--,u++)
            {
                long tem=0;
                int k,d=s[i].charAt(u)-'0';
                for(k=1;k<=j;k++)   //numbers ending before that point
                tem=(tem+p[j+k]*d*c[k]*2)%M;
                for(k=j+1;k<12;k++)     //numbers ending at and after that point
                {
                    tem=(tem+p[2*j]*d*c[k])%M;
                    tem=(tem+p[2*j+1]*d*c[k])%M;
                }
                //System.out.println(tem+" "+d);
                ans=(ans+tem)%M;
            }
        }
        System.out.print(ans);
    }
}