import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N[] = new int[100];
    int n = sc.nextInt();
    int m = 0;
    for (int i = 0; i < n; i++) N[i] = sc.nextInt();
    for (int i = 0; i < n-1; i++) {
        int min = i;
        for (int j = i+1; j < n; j++) {
            if (N[j] < N[min]) {
                min = j;
            }
        }
        if (min != i) m++;
        int temp = N[i];
        N[i] = N[min];
        N[min] = temp;
    }
    for (int i = 0; i < n; i++) {
      if (i == 0) System.out.printf("%d", N[i]);
      else System.out.printf(" %d", N[i]);
    }
    System.out.printf("\n");
    System.out.println(m);
  }
}

