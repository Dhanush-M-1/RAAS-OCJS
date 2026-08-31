import java.util.Arrays;
import java.io.*;

public class B {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException {
        String[] a = br.readLine().split(" ");
        int t = Integer.parseInt(a[0]);
        int m = Integer.parseInt(a[1]);

        int count = 0;
        int[] mem = new int[m];
        Arrays.fill(mem, 0, m, -1);
        while (t-- > 0) {
            String[] inst = br.readLine().split(" ");
            if (inst[0].equals("alloc")) {
                int n = Integer.parseInt(inst[1]);
                int p = find(mem, m, n);
                if (p < 0) {
                    System.out.println("NULL");
                } else {
                    count++;
                    Arrays.fill(mem, p, p + n, count);
                    System.out.println(count);
                }
            } else if (inst[0].equals("erase")) {
                int x = Integer.parseInt(inst[1]);
                for (int j = 0; ; j++) {
                    if (j == m || x <= 0) {
                        System.out.println("ILLEGAL_ERASE_ARGUMENT");
                        break;
                    }
                    if (mem[j] == x) {
                        do { mem[j++] = -1; } while (j < m && mem[j] == x);
                        break;
                    }
                }
            } else {
                // defragment
                int j = 0;
                for (int i = 0; i < m; i++) {
                    if (mem[i] > 0) {
                        mem[j] = mem[i];
                        j++;
                    }
                }
                Arrays.fill(mem, j, m, -1);
            }
        }   
    }
    private static int find (int[] mem, int m, int n) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            if (mem[i] == -1) {
                count++;
            } else {
                count = 0;
            }
            if (count == n) {
                return i - n + 1;
            }
        }
        return -1;
    }
}
