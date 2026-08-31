import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(
            new InputStreamReader(System.in)
    );

    public static void main(String[] args) throws IOException {
        short tests = Short.parseShort(input.readLine());

        while (tests-- > 0) {
            String[] x = input.readLine().split(" ");
            int a = Integer.parseInt(x[0]);
            int b = Integer.parseInt(x[1]);
            int n = Integer.parseInt(x[2]);

            System.out.println(solve(a, b, n));
        }
    }

    public static long solve(int a, int b, int n) {
        if (n % 3 == 0)
            return a;
        if (n % 3 == 1)
            return b;
        return b ^ a;
    }
}
