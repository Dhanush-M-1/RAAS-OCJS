import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    int[] x = new int[n];
    for (int i = 0; i < n; i++) {
        x[i] = sc.nextInt();
    }

    int cnt = 0;
    for (int i = 0; i < n; i++) {
        if (isPrime(x[i])) cnt++;
    }

    System.out.println(cnt);
  }

  public static boolean isPrime(int n) {
      if (n == 1) return false;
      
      for (int i = 2; i <= Math.sqrt(n); i++) {
          if (n % i == 0) return false;
      }
      return true;
  }
}
