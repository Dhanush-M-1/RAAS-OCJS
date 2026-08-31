
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class BearAndTwoPaths {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder("-1");
        String[] inData = br.readLine().split(" ");
        int n = Integer.parseInt(inData[0]);
        int k = Integer.parseInt(inData[1]);
        inData = br.readLine().split(" ");
        int a = Integer.parseInt(inData[0]);
        int b = Integer.parseInt(inData[1]);
        int c = Integer.parseInt(inData[2]);
        int d = Integer.parseInt(inData[3]);
        int[] arr;
        if (n > 4 && k > n) {
            arr = new int[n - 4];
            sb.delete(0, sb.length());
            for (int i = 0, j = 1; i <= n && j <= n; j++) {
                if (a != j && b != j && c != j && d != j) {
                    arr[i] = j;
                    i++;
                }
            }
            sb.append(a + " " + c + " ");
            for (int i = 0; i < n - 4; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append(d + " " + b + "\n");
            sb.append(c + " " + a + " ");
            for (int i = 0; i < n - 4; i++) {
                sb.append(arr[i] + " ");
            }
            sb.append(b + " " + d + "\n");
        }
        pw.print(sb);
        pw.close();
    }
}
