import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),m=Integer.parseInt(s[1]);
        int i,d[]=new int[m+1];
        for(i=1;i<=m;i++) d[i]=i;

        long ans=1,M=1000000007;
        ArrayList<Integer> al=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            int u=Integer.parseInt(s[0]),a=0,b=0;
            a=Integer.parseInt(s[1]);
            if(u==2) b=Integer.parseInt(s[2]);
            a=find(a,d); b=find(b,d);
            if(a!=b)
            {
                d[a]=b;
                ans=ans*2%M;
                al.add(i);
            }
        }
        sb.append(ans+" "+al.size()+"\n");
        for(int x:al)
            sb.append(x+1+" ");
        System.out.print(sb);
    }

    static int find(int x,int d[])
    {
        if(d[x]==x) return x;
        d[x]=find(d[x],d);
        return d[x];
    }
}
