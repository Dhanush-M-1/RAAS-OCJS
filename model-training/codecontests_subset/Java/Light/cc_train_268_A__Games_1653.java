import java.io.*;
import java.util.*;

public class games{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      
      int n = in.nextInt();
      
      int[] home = new int[n];
      int[] away = new int[n];
      
      for (int i = 0; i < n; i++){
         home[i]=in.nextInt();
         away[i]=in.nextInt();
      }
      
      int h;
      int a;
      int count = 0;
      for (int j = 0; j < n; j++){
         h = home[j];
         for (int k = 0; k < n; k++){
            if (k == j){
               continue;
            }
            a = away[k];
            if (a == h){
               count ++;
            }
         }
      }
      System.out.println(count);
   }
}
       
               
         