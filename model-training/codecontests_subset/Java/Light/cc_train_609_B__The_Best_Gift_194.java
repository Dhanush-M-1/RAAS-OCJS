import java.util.Scanner;


public class A_P {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int [] a = new int[11];
    
    for (int i = 1; i <= n; i++) {
        a[sc.nextInt()]++;
    }
    long sum = 0;
    for (int i = 1; i < 10; i++) {
        for (int j = i+1; j <= 10; j++) {
                sum += a[i] *1l * a[j] * 1l;
        }
    }
    System.out.println(sum);
}
}
