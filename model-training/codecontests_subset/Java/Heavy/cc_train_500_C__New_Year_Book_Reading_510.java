
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by brajesh.k on 05/09/15.
 */
public class Problem500C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int[] weight = new int[n];
        boolean[] used = new boolean[n];
        int[] bookStack = new int[n];
        int[] turn = new int[m];
        int count = 0;

        line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(line[i]);
            used[i] = false;
        }

        line = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            turn[i] = Integer.parseInt(line[i]) - 1;
            if(!used[turn[i]]) {
                used[turn[i]] = true;
                bookStack[count++] = turn[i];
            }
        }

        for (; count < n; count++) {
            bookStack[count] = count;
        }

        int ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(bookStack[j] == turn[i]) {
                    for (int k = j; k >= 1; k--) {
                        bookStack[k] = bookStack[k - 1];
                    }
                    bookStack[0] = turn[i];
                    break;
                }
                ret += weight[bookStack[j]];
            }
        }

        System.out.println(ret);
    }
}
