import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int count = 0;
        for(int i =0; i < n; i++) {
            int minj = i;
            for(int j = i; j < n; j++) {
                if(a[j] < a[minj]) {
                    minj = j;
                }
            }
            if (i != minj) {
                int tmp = a[i];
                a[i] = a[minj];
                a[minj] = tmp;
                count += 1;
            }
        }
        System.out.printf("%d", a[0]);
        for(int i = 1; i < n; i ++) {
            System.out.printf(" %d", a[i]);
        }
        System.out.printf("\n");
        System.out.println(count);
    }
}
