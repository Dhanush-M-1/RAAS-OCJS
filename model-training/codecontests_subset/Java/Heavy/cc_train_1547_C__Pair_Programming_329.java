import java.io.*;

public class C {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(inp.readLine());
        while (t-- > 0) {
            inp.readLine();
            String[] knm = inp.readLine().trim().split(" ");
            int k = Integer.parseInt(knm[0]);
            int n = Integer.parseInt(knm[1]);
            int m = Integer.parseInt(knm[2]);
            String[] na = inp.readLine().trim().split(" ");
            String[] ma = inp.readLine().trim().split(" ");
            int[] nArr = new int[n];
            int[] mArr = new int[m];
            for (int i = 0; i < n; i++) {
                nArr[i] = Integer.parseInt(na[i]);
            }
            for (int i = 0; i < m; i++) {
                mArr[i] = Integer.parseInt(ma[i]);
            }
            boolean possible = true;
            int[] arr = new int[n + m];
            int ind = 0, i = 0, j = 0;
            while (ind < n+m) {
                if (i < n && nArr[i] <= k) {
                    arr[ind] = nArr[i];
                    if (nArr[i] == 0) {
                        k++;
                    }
                    i++;
                    ind++;
                } else if (j < m && mArr[j] <= k) {
                    arr[ind] = mArr[j];
                    if (mArr[j] == 0) {
                        k++;
                    }
                    j++;
                    ind++;
                } else {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                for (int q = 0; q < arr.length; q++) {
                    out.write(arr[q] + " ");
                }
            } else {
                out.write("-1");
            }
            out.write("\n");
            out.flush();
        }
    }
}