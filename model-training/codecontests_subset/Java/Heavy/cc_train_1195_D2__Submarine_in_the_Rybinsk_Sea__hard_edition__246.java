import java.util.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class A
{
      public static void main(String ar[]) throws Exception
      {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            long mod=998244353;
            long a[]=new long[20];
            a[0]=1;
            for(int i=1;i<=19;i++)
             a[i]=(a[i-1]*10)%mod;
            HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
            int n=Integer.parseInt(br.readLine());
            String s1[]=br.readLine().split(" ");
            for(int i=0;i<n;i++)
            {
                  int u=s1[i].length();
                  if(hm.containsKey(u))
                   hm.put(u,1+hm.get(u));
                  else
                   hm.put(u,1);
            }
            
            long t=0;
            for(int i=0;i<n;i++)
            {
                  for(int j:hm.keySet())
                  {
                        long S=0;
                        int l=s1[i].length()-1;
                        int u=l;
                        int l1=j;
                        int r=0;
                        while(u>=0)
                        {
                              long p=s1[i].charAt(u)-48;
                              long ll=(a[r]*p)%mod;
                              S=(S+ll)%mod;
                              if(l1>0)
                              { l1--; r+=2; }
                              else
                               r++;
                              u--;
                        }
                        
                        u=l;
                        l1=j-1;
                        r=1;
                        while(u>=0)
                        {
                              long p=s1[i].charAt(u)-48;
                              long ll=(a[r]*p)%mod;
                              S=(S+ll)%mod;
                              if(l1>0)
                              { l1--; r+=2; }
                              else
                               r++;
                              u--;
                        }
                        long x=(long)hm.get(j);
                        S=(S*x)%mod;
                        t=(t+S)%mod;
                  }
            }
            System.out.println(t);
      }
}