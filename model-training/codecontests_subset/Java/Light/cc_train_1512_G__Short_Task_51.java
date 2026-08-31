import java.util.*;
public class Main
{
    
    public static void main(String args[])
    {
        int n=(int)1e7+100;
        long s[]=new long[n];
        int d[]=new int[n];
        int res[]=new int[n];
        Scanner sc=new Scanner(System.in);
        Arrays.fill(d,-1);
        d[1]=1;
        for(int i=2;i*i<n;i++)
        {
            if(d[i]==-1)
                d[i]=i;
            for(int j=i*i;j<n;j=j+i)
            {
                if(d[j]==-1)
                    d[j]=i;
            }
        }
        s[1]=1;
        for(int i=2;i<n;i++)
        {
            if(d[i]==-1)
            {
                d[i]=i;
                s[i]=i+1;
            }
            else
            {
                int j=i;
                s[i]=1;
                while(j%d[i]==0)
                {
                    j=j/d[i];
                    s[i]=s[i]*d[i]+1;
                }
                s[i]=s[i]*s[j];
            }
        }
        Arrays.fill(res,-1);
        for(int i=n-1;i>0;i--)
        {
            if(s[i]<n)
                res[(int)s[i]]=i;
        }
        int t=sc.nextInt();
        for(int p=0;p<t;p++)
        {
            int x=sc.nextInt();
            System.out.println(res[x]);
        }
    }
}