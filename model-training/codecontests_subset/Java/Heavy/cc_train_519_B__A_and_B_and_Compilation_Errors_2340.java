import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main
{
    
   
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int row = n-2;
       int a[] = new int[n];
       int b[] = new int[n-1];
       int c[] = new int[n-2];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
            
        }
        for (int i = 0; i < n-1; i++) {
            b[i]= input.nextInt();
        }
        for (int i = 0; i < n-2; i++) {
            c[i] = input.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int i=0;
        int ansone =-1,anstwo=-1;
       while(i<n-1)
       {
           if(b[i]!=a[i])
           {
               ansone = a[i];   
               break;
           }
           i++;
       }
       if(ansone==-1)
       {
           System.out.println(a[n-1]);
       }else
            System.out.println(ansone);
       i=0;
         while(i<n-2)
       {
           if(b[i]!=c[i])
           {
               anstwo = b[i];   
               break;
           }
           i++;
       }
         if(anstwo==-1)
       {
           System.out.println(b[n-2]);
       }else
            System.out.println(anstwo);
       
        
    }

   
   
}



