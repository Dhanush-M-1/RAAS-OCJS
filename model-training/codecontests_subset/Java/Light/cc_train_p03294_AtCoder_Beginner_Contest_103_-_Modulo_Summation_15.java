import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = 0;

        for (int i = n; i > 0; i--) {
            int a = sc.nextInt();
            s = s + a;
        }
        System.out.println(s - n);

    }
}

