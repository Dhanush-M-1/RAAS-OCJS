//package codeforcesround307;
import java.io.*;
import java.util.*;
public class q1 {
    static int[] ss,aa,bb;
    static boolean[][] dp;
    static int x,y;
    public static void main(String[] args) throws Exception
    {
        //StringTokenizer st=new StringTokenizer(br.readLine());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        ss=new int[26];
        aa=new int[26];
        bb=new int[26];
        String s=br.readLine();
        String a=br.readLine();
        String b=br.readLine();
        for(int i=0;i<s.length();i++)
        {
            ss[s.charAt(i)-'a']++;
            
        }
        for(int i=0;i<a.length();i++)
        {
            aa[a.charAt(i)-'a']++;
        }
        for(int i=0;i<b.length();i++)
        {
            bb[b.charAt(i)-'a']++;
        }
        x=0;y=0;
        int ans=100000000;
        for(int i=0;i<26;i++)
        {
            if(aa[i]!=0)
            {
                ans=Math.min(ans, ss[i]/aa[i]);
            }

        }
        for(int i=0;i<=ans;i++)
        {
            int tt=1000000;
            for(int k=0;k<26;k++)
            {
                if(bb[k]!=0)
                {
                    tt=Math.min(tt, (ss[k]-i*aa[k])/bb[k]);
                }
            }
            if(i+tt>(x+y))
            {
                x=i;
                y=tt;
            }
        }
        for(int i=0;i<26;i++)
        {
            ss[i]-=(x*aa[i]+y*bb[i]);
        }
        //String sd="";
        for(int i=0;i<x;i++)
        {
            pw.print(a);
        }
        for(int i=0;i<y;i++)
        {
            pw.print(b);
        }
        for(int i=0;i<26;i++)
        {
            for(int j=0;j<ss[i];j++)
            {
                pw.print((char)('a'+i));
            }
        }
    
        pw.close();
    }
    
    

}
