import java.util.*;
public class ShortTask {
    public static void main(String[] args) {
        int N = 10000001;
        int[] lowPrime = new int[N];
        for (int i = 2; i < N; i++) {
            for (int j = i; j < N; j += i) {
                if (lowPrime[j] == 0) {
                    lowPrime[j] = i;
                }
            }
        }
        int[] divSum = new int[N], res = new int[N];
        divSum[1] = 1;
        Arrays.fill(res, -1);
        res[1] = 1;
        for (int i = 2; i < N; i++) {
            int j = i, k = 1, m = 0;
            while (j % lowPrime[i] == 0) {
                j /= lowPrime[i];
                k *= lowPrime[i];
                m++;
            }
            divSum[i] = lowPrime[i] == i ? i + 1 : k == i ? i + divSum[i / lowPrime[i]] : divSum[j] * divSum[k];
            if (divSum[i] < N && res[divSum[i]] == -1) {
                res[divSum[i]] = i;
            }
        }
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            int n = in.nextInt();
            System.out.println(res[n]);
        }
    }
}