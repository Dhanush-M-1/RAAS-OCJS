import java.io.*;
import java.util.*;
import java.lang.*;

public class Try1{
   public static void main(String[] args) {

      Scanner in = new Scanner(System.in);
      int a = in.nextInt();
      int b = in.nextInt();
      int gap = Math.abs(a - b);

      if((gap&1) == 1){
         gap /= 2;
         System.out.println((gap * (gap + 1) / 2) + ((gap + 1) * (gap + 2) / 2));
         
      }
      else{
         gap /= 2;
         System.out.println(gap * (gap + 1));
      }
      in.close();
   }

   public static void algo(int[] arrival, int threshold){
		//your implementation
	}
}