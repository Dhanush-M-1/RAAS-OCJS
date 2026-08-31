import java.util.*;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    
    long ans = 0;
    while(N > 0){
      ans += sc.nextLong() - 1;
      N--;
    }
    
    System.out.println(ans);
  }
}       