import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_R1 {

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(
                System.in));
        StringTokenizer st = null;
        String line = "";
        line = console.readLine();
        st = new StringTokenizer(line);
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int arr[] = new int[110];
        line = console.readLine();
        st = new StringTokenizer(line);
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        int res = -1;
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1])
                res = Math.max(arr[i] - arr[i + 1] - c, res);
        }
        res = (res == -1) ? 0 : res;
        System.out.println(res);

    }
}
