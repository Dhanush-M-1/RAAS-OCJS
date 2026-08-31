import java.util.Scanner;

public class P385A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int prev = -100;
        int prof = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = sc.nextInt();
            if (tmp < prev)
                prof = Math.max(prof, prev - tmp);
            prev = tmp;
        }
        sc.close();
        if (prof - c < 0)
            System.out.println(0);
        else
            System.out.println(prof - c);
    }
}
