
import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Supplier;

public class MinimumInteger {
    static Supplier<Scanner> inputSupplier = () -> new Scanner(System.in);
    static Supplier<PrintStream> outSupplier = () -> System.out;
    public static void main(String[] args) {
        Scanner sc = inputSupplier.get();
        PrintStream out = outSupplier.get();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int q = sc.nextInt();
            if (q < l || q>r) {
                out.println(q);
            } else {
                int m = r / q;
                out.println((m + 1) * q);
            }
        }
        out.flush();
        out.close();
    }
}