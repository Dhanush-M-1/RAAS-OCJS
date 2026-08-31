import java.util.*;
import java.io.*;
/**
 * Write a description of A here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class A 
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine().trim();
        int n = Integer.parseInt(br.readLine());
        int flag1=0;
        int flag2=0;
        for(int i=0;i<n;i++)
        {
         String inp=br.readLine().trim();
         int index1=inp.indexOf(exp.charAt(0),1);
         int index2=inp.indexOf(exp.charAt(1));
         
         if(inp.equals(exp))
         {
             flag1=1;
             flag2=1;
             break;
         }
         if(index1==1)
         flag1=1;
         if(index2==0)
         flag2=1;
         
        }
        if(flag1==1&&flag2==1)
        System.out.println("YES");
        else
        System.out.println("NO");
        br.close();
    }

}
