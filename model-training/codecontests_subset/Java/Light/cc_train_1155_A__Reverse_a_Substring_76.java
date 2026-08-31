import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Balloons
{
    public static void main (String[] args) throws java.lang.Exception
    {
    try {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());  
        String s=br.readLine();
        char s1[]=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        int l=0,r=0,dif=0;
        for(int i=1;i<n;i++)
        {
            if(s1[i]<s1[i-1])
            {
            System.out.println("Yes");
            System.out.println(i+" "+(i+1));
            System.exit(0);
            }
        }
        System.out.println("No");
        
    } catch(Exception e) {
    return;}
    }
}
