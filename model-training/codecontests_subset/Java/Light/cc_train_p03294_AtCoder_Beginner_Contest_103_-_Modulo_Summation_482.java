

import java.util.Scanner;

// modの最大値
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int res = 0;
        for(int i = 0; i < N; i++) {
            res += sc.nextInt();
        }
        System.out.println(res - N);
    }
}
