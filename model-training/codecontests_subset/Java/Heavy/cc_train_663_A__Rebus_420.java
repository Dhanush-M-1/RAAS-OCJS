
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.math.BigDecimal;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.String.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //(new FileReader("input.in"));
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;
        //PrintWriter pw = new PrintWriter("output.out", "UTF-8");

        //? + ? - ? + ? + ? = 42
        String s = in.readLine();
        int pos = 0, neg = 0, n;

        int cur = 0;

        List<Integer> list = new ArrayList<Integer>();
        if (s.startsWith("?")) {
            tk = new StringTokenizer(" + " + s);
        } else {
            tk = new StringTokenizer(s);
        }
        String str, ss;

        boolean f = true;

        str = tk.nextToken();
        if (str.equals("-")) {
            cur = 1;
            f = false;
        } else if (str.equals("+")) {
            cur = 0;
            f = true;
        }

        while (!str.equals("=")) {
            tk.nextToken();

            if (cur == 0) {
                pos++;
                list.add(0);
            } else {
                neg++;
                list.add(1);
            }

            str = tk.nextToken();
            cur = str.equals("+") ? 0 : 1;
        }

        n = parseInt(tk.nextToken());

        int A = n + neg, B = neg;
        if (B > A) {
            System.out.println("Impossible");
            return;
        }

        //System.out.println(A+" "+B);
        //System.out.println(pos+" "+neg);
        List<Integer> p = new ArrayList<Integer>();
        List<Integer> nn = new ArrayList<Integer>();
        int x = A / pos;
        int r = A % pos;
        
        boolean f1 = true;
        
        if (x > n || x + (r > 0 ? 1 : 0) > n) {
            System.out.println("Impossible");
            return;
        } else {
            if (x == 0) {
                if (pos - r > neg * (n - 1)) {
                    System.out.println("Impossible");
                    return;
                } else {
                    x++;
                    f1 = false;
                    int tmp = pos - r;
                    if (tmp < neg) {
                        while (tmp > 0) {
                            nn.add(2);
                            tmp--;
                        }
                        
                        while (nn.size() < neg) {
                            nn.add(1);
                        }
                    } else {
                        int y = tmp / neg;
                        int rr = tmp % neg;
                        while (nn.size() < neg) {
                            nn.add(1 + y + (rr > 0 ? 1 : 0));
                            if (rr > 0) {
                                rr--;
                            }
                        }
                    }
                }
            } else {
                while(nn.size() < neg)
                    nn.add(1);
            }
            
            while (p.size() < pos) {
                p.add((f1 || r==0 ? x : x-1) + (r > 0 ? 1 : 0));
                if (r > 0) {
                    r--;
                }
            }
        }

        pos = 0;
        neg = 0;
        out.append("Possible\n");
        if (!f) {
            out.append(" - ").append(nn.get(neg++));
        } else {
            out.append(p.get(pos++));
        }

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) == 0) {
                out.append(" + ").append(p.get(pos++));
            } else {
                out.append(" - ").append(nn.get(neg++));
            }
        }

        out.append(" = ").append(n);

        System.out.println(out);
    }
}
