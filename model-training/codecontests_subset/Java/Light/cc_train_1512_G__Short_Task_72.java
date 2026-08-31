import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int N=10000000,sum[]=new int[N+1],p[]=new int[N+1];
        sum[1]=1;
        int i,j;
        for(i=2;i<=N;i++)
        {
            sum[i]=Integer.MAX_VALUE;
            if(p[i]==0)
            for(j=i;j<=N;j+=i) p[j]=i;
        }

        for(i=2;i<=N;i++)
        {
            int x=i,sm=1,pr,c,mul;
            while(x!=1)
            {
                pr=p[x]; c=1; mul=1;
                while(x%pr==0)
                {
                    x/=pr;
                    mul*=pr;
                    c+=mul;
                }
                sm*=c;
            }
            if(sm<=N) sum[sm]=Math.min(sum[sm],i);
        }

        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            n=sum[n];
            if(n==Integer.MAX_VALUE) n=-1;
            sb.append(n+"\n");
        }
        System.out.print(sb);
    }
}