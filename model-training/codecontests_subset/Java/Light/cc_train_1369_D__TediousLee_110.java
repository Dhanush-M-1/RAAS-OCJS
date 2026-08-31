import java.util.*;
import java.io.*;
public class Main
{
    public static void main(String args[])throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int mx=(int)2e6+1;
        long zc[]=new long[mx];
        long oc[]=new long[mx];
        long tc[]=new long[mx];
        long ans[]=new long[mx];
        zc[1]=1;
        long  m=1000000007;
        for(int i=2;i<mx;i++)
        {
            zc[i]=(2*oc[i-1]+zc[i-1])%m;
            oc[i]=zc[i-1];
            tc[i]=(tc[i-1]+oc[i-1])%m;
            ans[i]=(tc[i]*4-(ans[i-1]+ans[i-2])%m+m)%m;
        }
        int t=Integer.parseInt(br.readLine());
        for(int x=0;x<t;x++)
        {
            int n=Integer.parseInt(br.readLine());
            pw.println(ans[n]);
        }
        pw.flush();
        pw.close();
    }
}