import java.util.Scanner;
import java.util.Arrays;

public class NewClass5 {
    public static void main(String[] args) {
    Scanner in=new Scanner (System.in);
   int x=in.nextInt();
   long z=0,y=0;
    int [] arr=new int[x];
    for (int i=0;i<x;i++){
        arr[i]=in.nextInt();
      
    }
 
             Arrays.sort( arr);
             for (int i=x-1;i>=0;i--){
             if (arr[i]>500000)
            z=1000000-arr[i];
             }
             
               for (int i=x-1;i>=0;i--)
               {
                   if (arr[i]<=500000)
                   {
                       y=arr[i];
                       break;
                   }
               }
               
                   y-=1;
                   if (y>z)
                       System.out.println(y);
                   else
                       System.out.println(z);
                       
    
    }
}


 
