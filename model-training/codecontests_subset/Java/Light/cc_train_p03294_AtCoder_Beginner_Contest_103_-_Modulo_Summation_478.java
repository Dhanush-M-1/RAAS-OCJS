import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int a[] = new int[N];
    long m = 0;
    for (int i = 0; i < N; i++) {
      a[i] = sc.nextInt();
      m += a[i];
    }
    System.out.println(m - N);
  }
}