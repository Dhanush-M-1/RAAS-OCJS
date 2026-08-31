import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Euler {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        PrintWriter out = new PrintWriter(System.out);
        for (int t1 = 0; t1 < t; t1++) {
            StringTokenizer tokenizer = new StringTokenizer(f.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            long l = Long.parseLong(tokenizer.nextToken()) - 1;
            long r = Long.parseLong(tokenizer.nextToken()) - 1;
            int level = 1;
            long index = 0;
            boolean hadFirst = false;
            while (level < n) {
                long end = index + (n - level) * 2 - 1;
                if (intersect(l, r, index, end)) {
                    for (int i = 0; i < n - level; i++) {
                        if (l <= index + i * 2 && index + i * 2 <= r) {
                            if (hadFirst) {
                                out.print(" ");
                                out.print(level);
                            } else {
                                out.print(level);
                                hadFirst = true;
                            }
                        }

                        if (l <= index + i * 2 + 1 && index + i * 2 + 1 <= r) {
                            if (hadFirst) {
                                out.print(" ");
                                out.print(level + i + 1);
                            } else {
                                out.print(level + i + 1);
                                hadFirst = true;
                            }
                        }
                    }
                }

                index = end + 1;
                level++;
            }
            if (l <= index && index <= r) {
                if (hadFirst) {
                 out.print(" ");
                 out.print(1);
                } else {
                    out.print(1);
                    hadFirst = true;
                }
            }
            out.println();
        }
        out.close();
    }

    private static boolean intersect(long start1, long end1, long start2, long end2) {
        return Math.min(end1, end2) >= Math.max(start1, start2);
    }


}
