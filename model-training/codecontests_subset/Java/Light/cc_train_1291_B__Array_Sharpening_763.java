import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1291 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0; t<T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int[] A = new int[N];
            for (int n=0; n<N; n++) {
                A[n] = Integer.parseInt(tokenizer.nextToken());
            }
            int incIdx = 0;
            while (incIdx < N && A[incIdx] >= incIdx) incIdx++;
            incIdx--;
            int decIdx = N-1;
            while (decIdx >= 0 && A[decIdx] >= N-1-decIdx) decIdx--;
            decIdx++;
            boolean possible = decIdx <= incIdx;
            System.out.println(possible ? "Yes" : "No");
        }
    }

}
