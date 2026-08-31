import java.util.*;
import java.io.*;
import java.lang.*;
public class aks
{
    public static void main(String args[])throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        int n=Integer.parseInt(br.readLine());
        int first[]=new int[26];
        int last[]=new int[26];String m="";
        for(int i=0;i<n;i++)
        {
            m=br.readLine();
            first[(int)m.charAt(0)-97]++;
            last[(int)m.charAt(1)-97]++;
            if(m.equals(s))
            {
                System.out.println("YES");
                System.exit(0);
            }
        }
        
        if((last[s.charAt(0)-97]!=0&&first[s.charAt(1)-97]!=0))
        System.out.println("YES");
        else
        System.out.println("NO");
    }
}