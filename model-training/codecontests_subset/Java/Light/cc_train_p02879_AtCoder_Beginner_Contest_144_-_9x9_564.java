import java.util.*;

public class Main {
  public static void main(String[] args ) throws Exception {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
   if(A<=9&&B<=9){
   	System.out.print(A*B);
   }else{
   	System.out.print(-1);
 	 }
  }
}