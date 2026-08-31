import java.util.*;
public class algo_1805
{
    public static void main(String args[])
    {
        Scanner ex=new Scanner(System.in);
        int n=ex.nextInt();
        long arr[]=new long[n];
        long mod=998244353;
        for(int i=0;i<n;i++)
        arr[i]=ex.nextLong();
        int count[]=new int[10];
        for(int i=0;i<n;i++)
        {
            String s=""+arr[i];
            count[s.length()-1]++;
        }
        long ans=0;
        long sum[]=new long[20];
        for(int i=0;i<n;i++)
        {
            String s=""+arr[i];
            int len=s.length();
            for(int j=9;j>=0;j--)
            {
                long temp=arr[i];
                int num=count[j];
                int pos=0;
                for(int k=0;k<len;k++)
                {
                    if(k<=j)
                    {
                        sum[pos]=sum[pos]+num*(temp%10);
                        sum[pos]=sum[pos]%mod;
                        pos++;
                        sum[pos]=sum[pos]+num*(temp%10);
                        sum[pos]=sum[pos]%mod;
                        pos++;
                        temp=temp/10;
                    }
                    else
                    {
                        sum[pos]=sum[pos]+(2*num)*(temp%10);
                        sum[pos]=sum[pos]%mod;
                        pos++;
                        temp=temp/10;
                    }
                }
            }
        }
        long mul=1;
        for(int i=0;i<20;i++)
        {
            long pro=mul*sum[i];
            pro=pro%mod;
            ans=ans+pro;
            ans=ans%mod;
            mul=mul*10;
            mul=mul%mod;
        }
        System.out.println(ans);
    }
}