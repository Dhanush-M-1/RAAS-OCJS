import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(sc.next());
            ans += temp - 1;
        }
        System.out.println(ans);
    }
}