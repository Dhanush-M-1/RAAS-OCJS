import java.util.Scanner;  
import java.util.*; 
import java.util.Arrays; 

public class Solution
{ 
    public static void main(String[] args) 
    { 
        
        Scanner sc = new Scanner(System.in); 
        int a=sc.nextInt();
        int b=sc.nextInt();
        
        if(Math.abs(a-b)==1)
        {
            System.out.println("1");
            System.exit(0);
        }
        if(Math.abs(a-b)==2)
        {
            System.out.println("2");
            System.exit(0);
        }
        
        int h=Math.abs(a-b);
        //System.out.println(h);
        int g=h/2;
        //System.out.println(g);
        int p=g*(g+1)/2;
        //System.out.println(p);
        if(h%2==0)
        {
            System.out.println(p*2);
        }
        else
        {
            int o=(p*2)+(g+1);
            System.out.println(o);
            
        }
        
        
    } 
    
} 