import java.io.*;
import java.util.*;

public final class MemoryManager {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(tk.nextToken());
        int m = Integer.parseInt(tk.nextToken());
        int[] a = new int[m];
        int seq = 1;
        List<String> r = new ArrayList<String>();
        for (int i = 0; i < t; i++) {
            tk = new StringTokenizer(br.readLine());
            String op = tk.nextToken();
             if (op.equals("alloc")) {
                int sz = Integer.parseInt(tk.nextToken());
                int av = 0, offset = 0;
                while (av != sz && offset < m)
                    if (a[offset++] != 0) av = 0; else av++;

                if (av == sz) {
                    for (int j = 1; j <= av; j++) a[offset - j] = seq;
                    r.add("" + (seq++));
                }
                else r.add("NULL");
            }
            else if (op.equals("erase")) {
                int id = Integer.parseInt(tk.nextToken());
                int j = 0;

                while (j < m && a[j] != id) { j++; }

                if (j == m || id == 0) r.add("ILLEGAL_ERASE_ARGUMENT");
                else while (j < m && a[j] == id) a[j++] = 0;
            }
            else if (op.equals("defragment")) {
                int e = -1, f = 0;
                while (f < m) {
                    if (a[f] > 0 && e >= 0) {
                            a[e] = a[f];
                            a[f] = 0;
                            e++;
                    }
                    else if (a[f] == 0 && e == -1) e = f;

                    f++;
                }
            }
        }
        for (String str : r) System.out.println(str);
    }
}
