import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int i,j,N=500000;
        f=new long[N];
        f[0]=1;
        for(i=1;i<N;i++)
        f[i]=f[i-1]*i%M;

        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
        int a[]=new int[2*n];
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            int l=Integer.parseInt(s[0]),r=Integer.parseInt(s[1]);
            a[i]=2*l;
            a[n+i]=2*r+1;
        }
        Arrays.sort(a);

        long ans=0; int bal=0;
        for(i=0;i<2*n;)
        {
            int l=i,add;
            while(i<2*n && a[l]==a[i]) i++;
            add=i-l;
            if(a[l]%2==0)
            {
                ans+=(ncr(bal+add,k)-ncr(bal,k)+M)%M;
                ans%=M;
                bal+=add;
            }
            else bal-=add;
        }
        System.out.print(ans);
    }

    static long f[],M=998244353;

    static long ncr(int n,int r)
    {
        if(r>n) return 0;
        return f[n]*power(f[r],M-2)%M*power(f[n-r],M-2)%M;
    }

    static long power(long a,long b)
    {
        long res=1;
        while(b!=0)
        {
            if(b%2==1) res=res*a%M;
            b>>=1;
            a=a*a%M;
        }
        return res;
    }
}