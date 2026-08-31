
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.function.Supplier;
import java.util.*;

public class RevSubstr {
    static Supplier<InputStream> inputSupplier = () -> System.in;
    static Supplier<PrintWriter> outSupplier = () -> new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(inputSupplier.get());
        PrintWriter out = outSupplier.get();
        int n = sc.nextInt();
        String s = sc.next();
        int[] ret = solve(s);
        if (ret == null) {
            out.println("NO");
        } else {
            out.println("YES");
            out.println(""+ret[0]+" "+ret[1]);
        }
        sc.close();
        out.close();
    }

    private static int[] solve(String s) {
        int n = s.length();
        if(n<2) return null;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) > s.charAt(i)) {
                return new int[]{i, i+1};
            }
        }
        return null;
    }

}