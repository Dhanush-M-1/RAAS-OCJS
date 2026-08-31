
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class a {

    private static final boolean localEnv = false;

    private void solve(Scanner in, PrintWriter out) {
        String exp = in.nextLine();
        String[] parts = exp.split(" = ");
        int n = Integer.parseInt(parts[1]), pos = 1, neg = 0;
        for (char chr: parts[0].toCharArray()) {
            if (chr == '+') ++pos;
            if (chr == '-') ++neg;
        }
        int minPossible = pos - neg * n, maxPossible = n * pos - neg;
        if (!(minPossible <= n && n <= maxPossible)) {
            out.printf("Impossible\n");
            return;
        }
        List<Integer> negVals = new ArrayList<>(), posVals = new ArrayList<>();
        int posLeft = pos, negLeft = neg, sum = 0;
        for (int i = 0; i < pos + neg; ++i) {
            int sign = i < pos ? 1 : -1;
            if (sign == 1) {
                --posLeft;
            } else {
                --negLeft;
            }
            for (int x = 1; x <= n; ++x) {
                int minLeft = sum + sign * x + posLeft - n * negLeft;
                int maxLeft = sum + sign * x + n * posLeft - negLeft;
                if (minLeft <= n && n <= maxLeft) {
                    if (sign == 1) {
                        posVals.add(x);
                        sum += x;
                    } else {
                        negVals.add(x);
                        sum += -x;
                    }
                    break;
                }
            }
        }
        boolean plusSign = true;
        out.printf("Possible\n");
        for (int i = 0, posIdx = 0, negIdx = 0; i < parts[0].length(); ++i) {
            char chr = parts[0].charAt(i);
            if (chr == ' ') {
                out.printf(" ");
            }
            if (chr == '-' || chr == '+') {
                plusSign = (chr == '+');
                out.printf("%c", chr);
            }
            if (chr == '?') {
                if (plusSign) {
                    out.printf("%d", posVals.get(posIdx));
                    ++posIdx;
                } else {
                    out.printf("%d", negVals.get(negIdx));
                    ++negIdx;
                }
            }
        }
        out.printf(" = %d\n", n);
    }

    public static void main(String[] args) {
        String basePath = localEnv ? System.getProperty("user.dir") + "/src/task_663/" : null;
        try {
            Scanner in = localEnv ? new Scanner(new File(basePath + "in")) : new Scanner(System.in);
            PrintWriter out =
                    localEnv ? new PrintWriter(new FileWriter(basePath + "out")) : new PrintWriter(System.out);
            new a().solve(in, out);
            in.close();
            out.close();
        } catch (IOException error) {
            System.out.println(error.getMessage());
        }
    }
}
