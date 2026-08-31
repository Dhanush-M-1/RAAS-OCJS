import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long step[] = new long[n+1];
        Arrays.fill(step, -1);
        step[0] = 1;
        step[1] = 1;

        for(int i=0; i < m; i++){
            int a = sc.nextInt();
            step[a] = 0;
        }

        for(int i=2; i <= n; i++){
            if(step[i] == -1) {
                step[i] = (step[i - 1] + step[i - 2]) % 1000000007;
            }
        }
        System.out.println(step[n]);
    }
}