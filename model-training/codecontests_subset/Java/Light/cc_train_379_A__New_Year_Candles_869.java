import java.util.Scanner;
public class Main{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      int a = input.nextInt();
      int b = input.nextInt();
      int sum = 0;
      int rem = 0;
      
      while(a>0){
         sum += a;
         rem += a % b;
         a = a/b ;
         if(rem >= b){
            a += 1;
            rem -= b;
         }
       
      }
     System.out.println(sum);
   }
} 