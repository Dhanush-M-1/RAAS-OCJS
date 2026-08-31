import java.io.*;
import java.util.*;
public class Main{
    
    public static void main(String[] args)
    {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        String s=sc.next();
        int count0=0;
        int count1=0;
        for(int i=0;i<t;i++)
        { if(s.charAt(i)=='0')
            count0++;
            else count1++;
            
        }
        if(count0!=count1 || t%2!=0)
        {
             System.out.println("1");
             System.out.println(s);
        }
        
        else {
        String s1="";
        String s2="";
        if(t%2==0)
        {
            s1=s1+Character.toString(s.charAt(0));
            s2=s.substring(1);
            System.out.println("2");
            System.out.println(s1+" "+s2);
        }
        
    }
        
    }
}