import java.util.Scanner;

public class R3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] count = new int[m];

        for(int i = 0; i < n; i++) {
            int x = scanner.nextInt() - 1;
            count[x]++;
        }

        int answer = 0;
        for(int i = 0; i < m-1; i++) {
            int num = 0;
            for(int y = i + 1; y < m; y++) {
                num += count[y];
            }
            answer += count[i] * num;
        }

        System.out.println(answer);
    }
}
