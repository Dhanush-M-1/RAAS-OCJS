import java.util.*;
public class cf235a {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    long ans = 1;
    for(int i=0; i<Math.min(n,100); i++)
      for(int j=i; j<Math.min(n,100); j++)
        for(int k=j; k<Math.min(n,100); k++)
          ans = Math.max(ans,lcm(n-i,n-j,n-k));
    System.out.println(ans);
  }
  static long lcm(long a, long b, long c) {
    return lcm(lcm(a,b),c);
  }
  static long lcm(long a, long b) {
    return a*b/gcd(a,b);
  }
  static long gcd(long a, long b) {
    return b==0?a:gcd(b,a%b);
  }
}
