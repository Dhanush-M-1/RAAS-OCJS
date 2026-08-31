import java.util.*;

public class Main{
 public static void main(String[] agrs){
  Scanner sc = new Scanner(System.in);
  int a = sc.nextInt();
  int b = sc.nextInt();
  if(a*b%2==0){
   System.out.println("Even");
  }else{
   System.out.println("Odd");
  }
 }
}
