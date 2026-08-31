
import java.util.*;
public class ACM {
    
    public static void main(String[] args)   
    {
        
          Scanner input = new Scanner(System.in);
      int n=input.nextInt();
      int c=input.nextInt();
     int arr[]= new int[n];
      int min=0,max=0;
      int sub=0;
        for (int i = 0; i < n; i++)
            arr[i]=input.nextInt();
            /*......................................*/
             for (int i = 0; i < n-1; i++){
                 if(sub<(arr[i]-arr[i+1])){
                    sub=(arr[i]-arr[i+1]);
                     max=arr[i];
                     min=arr[i+1];
                    
                 }
             }
        int x=max-min-c;
       
        System.out.println((x<0)?0:x);

    }

}