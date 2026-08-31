import java.util.*;
import java.lang.*;
import java.io.*;

public class A
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(bu.readLine());
        StringBuilder sb=new StringBuilder();
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            String s[]=bu.readLine().split(" ");
            boolean flag=true;
            int i,p[]=new int[n],c[]=new int[n];
            p[0]=Integer.parseInt(s[0]); c[0]=Integer.parseInt(s[1]);
            if(p[0]<c[0]) flag=false;
            for(i=1;i<n;i++)
            {
                s=bu.readLine().split(" ");
                p[i]=Integer.parseInt(s[0]);
                c[i]=Integer.parseInt(s[1]);
                if(p[i]==p[i-1] && c[i]==c[i-1] && p[i]>=c[i]) continue;
                else if(p[i]>p[i-1] && c[i]>=c[i-1] && p[i]>=c[i] && (p[i]-p[i-1])>=(c[i]-c[i-1])) continue;
                else flag=false;
            }
            if(flag) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.print(sb);
    }
}