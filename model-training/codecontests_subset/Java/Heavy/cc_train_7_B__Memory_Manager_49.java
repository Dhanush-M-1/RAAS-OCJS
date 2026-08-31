import java.util.*;
import java.io.*;

public class Main {
    
    public void run() {
        int t = cin.nextInt();
        int m = cin.nextInt();
        int[] id = new int[m];
        int last = 0;
        for (int nt = 0; nt < t; ++nt) {
            String op = cin.next();
            if (op.equals("alloc")) {
                int n = cin.nextInt();
                int got = 0;
                boolean flag = false;
                for (int i = 0; i < m; ++i) {
                    if (id[i] == 0) {
                        ++got;
                        if (got >= n) {
                            flag = true;
                            ++last;
                            for (int j = i; j > i - n; --j) {
                                id[j] = last;
                            }
                            out.println(last);
                            break;
                        }
                    } else {
                        got = 0;
                    }
                }
                if (!flag) {
                    out.println("NULL");
                }
            } else if (op.equals("erase")) {
                int n = cin.nextInt();
                boolean flag = false;
                if (n > 0) {
                    for (int i = 0; i < m; ++i) {
                        if (id[i] == n) {
                            flag = true;
                            id[i] = 0;
                        }
                    }
                }
                if (!flag) {
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } else {
                int delta = 0;
                for (int i = 0; i < m; ++i) {
                    if (id[i] > 0) {
                        id[i - delta] = id[i];
                    } else {
                        ++delta;
                    }
                }
                for (int j = m - delta; j < m; ++j) {
                    id[j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main sloved = new Main();
        sloved.run();
        sloved.out.close();
    }

    Scanner cin = new Scanner(System.in);
    PrintWriter out = new PrintWriter(System.out);
}
