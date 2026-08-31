import java.util.*;
import java.io.*;
public class Hi {
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      
      ArrayList<Integer> firstHalf = new ArrayList<Integer>();
      ArrayList<Integer> secondHalf = new ArrayList<Integer>();
      
      for(int i = 0; i < n; i++){
         int k = sc.nextInt();
         if(k <= 500000)   
            firstHalf.add(k);
         else 
            secondHalf.add(k);
      }
      
      Collections.sort(firstHalf);
      Collections.sort(secondHalf);
      
      int total = 0;
      if(firstHalf.size() > 0)
         total = Math.max(total,firstHalf.get(firstHalf.size()-1)-1);
      if(secondHalf.size() > 0)
         total = Math.max(total,1000000 - secondHalf.get(0));
      System.out.println(total);
      
   }
}