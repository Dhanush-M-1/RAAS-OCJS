import java.util.Scanner;  
import java.util.*; 
import java.util.Arrays;
import java.util.Collections;
 
public class Solution
{ 
    
    public static void main(String[] args) 
    { 
        
        Scanner sc = new Scanner(System.in); 
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(s1+" "+s2);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String a=sc.next();
            String b=sc.next();
            //System.out.println(a+" "+b);
            if(a.equals(s1))
            {
                s1=b;
            }
            else
            {
                s2=b;
            }
            System.out.println(s1+" "+s2);
        }
    } 
    
}