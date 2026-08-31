import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Elections {
    static BufferedReader _in = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer _stk;
    static String next() {
        try {
            while (_stk == null || !_stk.hasMoreTokens())
                _stk = new StringTokenizer(_in.readLine());

            return _stk.nextToken();
        } catch(Exception ex) {
            throw new RuntimeException("Failed reading input", ex);
        }
    }
    static int nextInt() { return Integer.parseInt(next()); }

    public static void main(String [] args) throws IOException {
        int N = nextInt();
        int A[] = new int[N];
        int maxA = -1;
        int sumOther = 0;
        for(int i=0; i<N; i++) {
            A[i] = nextInt();
            maxA = Math.max(maxA, A[i]);
            sumOther += A[i];
        }

        int K=maxA;

        for(;K*N <= sumOther*2 ;K++) ;

        System.out.println(K);
    }


}