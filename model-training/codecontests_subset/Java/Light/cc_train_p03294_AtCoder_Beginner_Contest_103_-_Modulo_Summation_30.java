import java.util.*;
import java.lang.Math;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int ans = -n;
    
    for(int i = 0; i < n;i++) ans += sc.nextInt();
    	
    System.out.println(ans);
  }
}
