
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
     Scanner in = new Scanner(System.in);
     int ye = in.nextInt();
     int k = in.nextInt();
     int[] id = new int[ye];
     for (int i = 0 ; i < id.length ; i++){
         id[i] = in.nextInt();
     }     
     int i = 0 ;
     int num = 0;
     int res = 0;
      while (res < k) {
        
           i++; 
        
          res = res + i;
         
   
          
      }      
      res = res - i;
      System.out.println(id[k - res - 1]);       
                 }


}