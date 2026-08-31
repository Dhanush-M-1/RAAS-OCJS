import java.util.Scanner;
import java.util.*;

public class CFTrial 
{ 
  
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int count =a;
        
        if (b==1)
        {
            System.out.println(count*2);
        }
        else
        {
            while(a>=b)
            {                
                count+=a/b;
                a=a/b +a%b;
            }
            System.out.println(count);
        }
        
    }
}