import java.util.*;

public class Main {

    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[] nValue = new long[N + 1];
        nValue[0] = 1L;
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            nValue[a] = -1;
        }
        scanner.close();

        long calcValue = 1000000007;

        for (int i = 0; i < N + 1; i++) {
            if (nValue[i] < 0) {
                continue;
            }
            // 1段上がる場合
            int one = i + 1;
            if (one <= N && nValue[one] >= 0) {
                nValue[one] = (nValue[i] + nValue[one]) % calcValue;
            }
            // 2段上がる場合
            int two = i + 2;
            if (two <= N && nValue[two] >= 0) {
                nValue[two] = (nValue[i] + nValue[two]) % calcValue;
            }
        }

        System.out.println(nValue[N]);
    }
}
