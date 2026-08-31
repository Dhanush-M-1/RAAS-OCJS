import java.util.Scanner;

public class Main { 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    long[] a = new long[N];
    for (int i =0; i<N; i++) {
      a[i] = sc.nextLong();
    }
    long ans =0;
    for (int i =0; i<N; i++) {
      ans += a[i] -1;
    }
    System.out.println(ans);
  }
}