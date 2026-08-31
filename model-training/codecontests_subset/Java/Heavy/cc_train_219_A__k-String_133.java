import java.io.*;
import java.util.*;

public class test1
{

    public static void main(String[] args) throws Exception
    {
        new test1().run();
    }

    PrintWriter out = null;

    void run() throws Exception
    {
        Scanner in = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int k = in.nextInt();

        String s=in.next();
        
        int[] count=new int[26];
        
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)-'a']++;
        }
        
        boolean f=true;
        
        for(int i=0;i<26;i++)
        {
            if(count[i]%k!=0)
            {
               f=false;
               break;
            }
        }
        
        if(f)
        {
            StringBuffer sb=new StringBuffer();
            for(int i=0;i<26;i++)
            {
                for(int j=0;j<count[i]/k;j++)
                    sb.append((char)('a'+i));
            }
            
            for(int i=0;i<k;i++)
                out.print(sb.toString());
        }
        else
            out.println(-1);
        out.close();
    }
}