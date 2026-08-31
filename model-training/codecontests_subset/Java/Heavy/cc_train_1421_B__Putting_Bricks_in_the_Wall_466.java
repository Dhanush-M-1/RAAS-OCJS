
import java.util.Scanner;
import java.util.ArrayList;

public class B {

    private static class RC {
        public int r;
        public int c;
        public RC(int r, int c) {
            this.r = r + 1;
            this.c = c + 1;
        }
    }

    private static final String RESULT_PREFIX = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numTests = in.nextInt();
        for (int test = 0; test < numTests; ++test) {
            int n = in.nextInt();
            in.nextLine();
            char[][] board = new char[n][n];
            for (int i = 0; i < n; ++i) {
                board[i] = in.nextLine().toCharArray();
            }
            ArrayList<RC> ans = new ArrayList<>();
            if (board[0][1] == '0' && board[1][0] == '0') {
                // make sure they're are 1.
                if (board[n - 1][n - 2] == '0')
                    ans.add(new RC(n - 1, n - 2));
                if (board[n - 2][n - 1] == '0')
                    ans.add(new RC(n - 2, n - 1));
            } else if (board[0][1] == '1' && board[1][0] == '1') {
                // make sure they're are 0.
                if (board[n - 1][n - 2] == '1')
                    ans.add(new RC(n - 1, n - 2));
                if (board[n - 2][n - 1] == '1')
                    ans.add(new RC(n - 2, n - 1));
            } else if (board[n - 1][n - 2] == '0' && board[n - 2][n - 1] == '0') {
                // make sure we're at 1.
                if (board[0][1] == '0')
                    ans.add(new RC(0, 1));
                if (board[1][0] == '0')
                    ans.add(new RC(1, 0));
            } else if (board[n - 1][n - 2] == '1' && board[n - 2][n - 1] == '1') {
                // make sure we're at 0.
                if (board[0][1] == '1')
                    ans.add(new RC(0, 1));
                if (board[1][0] == '1')
                    ans.add(new RC(1, 0));
            } else {
                // make us 0, them 1.
                if (board[0][1] == '1')
                    ans.add(new RC(0, 1));
                if (board[1][0] == '1')
                    ans.add(new RC(1, 0));
                if (board[n - 1][n - 2] == '0')
                    ans.add(new RC(n - 1, n - 2));
                if (board[n - 2][n - 1] == '0')
                    ans.add(new RC(n - 2, n - 1));
            }
            System.out.println(RESULT_PREFIX + ans.size());
            for (RC curr : ans) {
                System.out.println(RESULT_PREFIX + curr.r + " " + curr.c);
            }
        }
    }
}