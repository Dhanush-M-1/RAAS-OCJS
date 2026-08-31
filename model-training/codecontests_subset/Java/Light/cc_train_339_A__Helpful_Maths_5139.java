import java.util.Scanner;
import java.util.Arrays;

public class Round1{
   public static void main(String[] args){
      Scanner in = new Scanner(System.in);
      
      String[] arr = in.nextLine().split("\\+");
      Arrays.sort(arr);
      
      String result="";
      
      for(int i=0; i<arr.length;i++){
         if(i!=arr.length-1)
           result += arr[i]+"+";
         else
            result += arr[i];       
      }
      System.out.println(result);
          
   }
}
   
