
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.function.Supplier;
import java.util.*;

public class Alternating {
    static Supplier<InputStream> inputSupplier = () -> System.in;
    static Supplier<PrintWriter> outSupplier = () -> new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(inputSupplier.get());
        PrintWriter out = outSupplier.get();
        int n = sc.nextInt();
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if(a%2==0) even.add(a);
            else odd.add(a);
        }
        Collections.sort(even);
        Collections.sort(odd);
        int nEven = even.size();
        int nOdd = odd.size();
        long result = 0;
        if (Math.abs(nEven - nOdd) <= 1) {
            result = 0;
        } else if(nEven>nOdd) {
            for (int i = 0; i < nEven-nOdd-1; i++) {
                result += even.get(i);
            }
        } else {
            for (int i = 0; i < nOdd-nEven-1; i++) {
                result += odd.get(i);
            }
        }
        out.print(result);

        sc.close();
        out.close();
    }
}
