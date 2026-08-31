import java.util.*;
import java.io.*;

public class B0007 {

    public static void main(String args[]) throws Exception {
        new B0007();
    }

    B0007() throws Exception {
        PandaScanner sc = null;
        PrintWriter out = null;
        try {
            sc = new PandaScanner(System.in);
            out = new PrintWriter(System.out);
        } catch (Exception ignored) {
        }

        int op = sc.nextInt();
        int mem = sc.nextInt();
        int idx = 1;
        int[] used = new int[mem];

        TreeSet<Integer> allocated = new TreeSet<Integer>();
        for (int i = 0; i < op; i++) {
            String cmd = sc.next();
            //Alloc
            if (cmd.compareTo("alloc") == 0) {
                int size = sc.nextInt();
                int success = -1;
                Search: for (int j = 0; j + size - 1 < mem; j++) {
                    if (used[j] == 0) {
                        for (int k = 0; k < size; k++) {
                            if (used[k + j] != 0) {
                                j += k;
                                break;
                            }
                            if (k == size - 1) {
                                success = j;
                                break Search;
                            }
                        }
                    }
                }
                if (success == -1) {
                    out.println("NULL");
                }
                else {
                    out.println(idx);
                    for (int k = 0; k < size; k++) {
                        used[success + k] = idx;
                    }
                    allocated.add(idx);
                    idx++;
                }
            }
            //Erase
            else if (cmd.compareTo("erase") == 0) {
                int r = sc.nextInt();
                if (!allocated.contains(r)) {
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                }
                else {
                    for (int j = 0; j < mem; j++) {
                        if (used[j] == r) {
                            used[j] = 0;
                        }
                    }
                    allocated.remove(r);
                }
            }
            //Defragment
            else {
                int last = -1;
                for (int j = 0; j < mem; j++) {
                    if (used[j] == 0 && last == -1) {
                        last = j;
                    }
                    else if (used[j] != 0 && last != -1) {
                        used[last] = used[j];
                        used[j] = 0;
                        last++;
                    }
                }
            }
//            out.println(Arrays.toString(used));
        }

        out.close();
        System.exit(0);
    }


    //The PandaScanner class, for Panda fast scanning!
    public class PandaScanner {
        BufferedReader br;
        StringTokenizer st;
        InputStream in;

        PandaScanner(InputStream in) throws Exception {
            br = new BufferedReader(new InputStreamReader(this.in = in));
        }

        public String next() throws Exception {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine().trim());
                return next();
            }
            return st.nextToken();
        }

        public boolean hasNext() throws Exception {
            return (st != null && st.hasMoreTokens()) || in.available() > 0;
        }

        public long nextLong() throws Exception {
            return Long.parseLong(next());
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(next());
        }
    }
}
