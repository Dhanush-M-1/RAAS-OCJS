import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
//        int t = scanner.nextInt();
        if(Math.abs(b - a) % 2 == 0) {
            int n = Math.abs(b-a), N = n/2;
            System.out.println(N * (N+1));
        } else {
            int n = Math.abs(b-a), N1 = (n-1)/2, N2 = (n+1)/2;
            System.out.println(((N1 * (N1 + 1)) / 2) + ((N2 * (N2 + 1)) / 2));

        }
    }
}


