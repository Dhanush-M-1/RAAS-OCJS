import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 7B
 * O(t*m) time
 * O(t + m) space
 *
 * @author artyom
 */
public class _7B implements Runnable {
    private BufferedReader in;
    private StringTokenizer tok;

    private Object solve() throws IOException {
        int t = nextInt(), m = nextInt();
        int[] pt = new int[m], sz = new int[m];
        List<String> out = new LinkedList<>();
        for (int i = 0, c = 0; i < t; i++) {
            out:
            switch (nextToken()) {
                case "alloc": {
                    int x = nextInt();
                    for (int j = 0, p = 0; j < m; j++) {
                        if (sz[j] > 0) {
                            j += sz[j] - 1;
                            p = 0;
                        } else if (++p == x) {
                            sz[j - p + 1] = x;
                            pt[j - p + 1] = ++c;
                            out.add(String.valueOf(c));
                            break out;
                        }
                    }
                    out.add("NULL");
                    break;
                }
                case "erase": {
                    int x = nextInt();
                    if (x > 0) {
                        for (int j = 0; j < m; j++) {
                            if (pt[j] == x) {
                                pt[j] = sz[j] = 0;
                                break out;
                            }
                        }
                    }
                    out.add("ILLEGAL_ERASE_ARGUMENT");
                    break;
                }
                case "defragment": {
                    for (int j = 0, k = 0; k < m; ) {
                        if (sz[k] > 0) {
                            if (k > j) {
                                int z = sz[j] = sz[k];
                                pt[j] = pt[k];
                                pt[k] = sz[k] = 0;
                                j += z;
                                k += z;
                            } else {
                                j += sz[k];
                                k += sz[k];
                            }
                        } else {
                            k++;
                        }
                    }
                }
            }
        }
        return String.join("\n", out);
    }

    //--------------------------------------------------------------
    public static void main(String[] args) {
        new _7B().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            tok = null;
            PrintStream out = System.out;
            out.print(solve());
            in.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    private String nextToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}