//package codeforcesround313;
import java.io.*;
import java.util.*;
public class q3 {
    public static void main(String[] args) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        //StringTokenizer st=new StringTokenizer(br.readLine());
        String s1=br.readLine();
        String s2=br.readLine();
        String temp1=equvi(s1);
        String temp2=equvi(s2);
        if(temp1.compareTo(temp2)==0)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
    public static String equvi(String s)
    {
        if(s.length()%2==1)
        {
            return s;
        }
        String s1=equvi(s.substring(0,s.length()/2));
        String s2=equvi(s.substring(s.length()/2,s.length()));
        if(s1.compareTo(s2)<0)
        {
            return s1+s2;
        }
        return s2+s1;
    }
    public static int ip(String s)
    {
        return Integer.parseInt(s);
    }
    public static long lp(String s)
    {
        return Long.parseLong(s);
    }

}
