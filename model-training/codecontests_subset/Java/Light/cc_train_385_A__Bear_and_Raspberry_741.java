import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main
{
   
 
  
    
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
       int n = input.nextInt();
       int k = input.nextInt();
       int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
           
                max =Math.max(max, a[i]-a[i+1]);
            
        }
        if(max-k<0)System.out.println(0);
        else
            System.out.println(max-k);
        
    }
}

