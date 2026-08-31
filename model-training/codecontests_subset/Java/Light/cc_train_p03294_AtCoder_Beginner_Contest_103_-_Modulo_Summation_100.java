import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt(), ans = 0, a;
    
    for(int i=0; i<N; i++) {
      a= sc.nextInt() -1;
      ans += a;
    }
    
    System.out.println(ans);
  }    
}
