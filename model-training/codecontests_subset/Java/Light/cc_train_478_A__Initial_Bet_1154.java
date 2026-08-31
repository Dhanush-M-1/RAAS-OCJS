import java.util.Scanner;
 public class Main {
 public static void main( String[] args ) {
 Scanner s = new Scanner(System.in) ;
 int sum=0,a;
 int b , e , f;
  for(int i=0;i<5;i++){
      a=s.nextInt();
      sum=sum+a;
  }
   if(sum!=0 && sum%5==0)
         System.out.println(b = sum/5);
  
   else{
      System.out.println(-1);
  }
 }
 }