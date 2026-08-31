import java.util.*;

public class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int ans = -1;
    if(A < 10 && B < 10){
      ans = A*B;
    }
    System.out.println(ans);
  }
}