import java.util.Locale;
import java.util.Scanner;

public class OrangeSolver {

    private String s;

    private int n;

    public static void main(String[] args) {
        OrangeSolver solver = new OrangeSolver();

        solver.readData();
        String solution = solver.solve();
        solver.print(solution);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    private void print(int[] values) {
        StringBuilder builder = new StringBuilder();

        for (int value : values) {
            builder.append(value);
            builder.append(" ");
        }

        print(builder);
    }

    private void print(Object value) {
        System.out.println(value);
    }

    private void print(boolean value) {
        System.out.println(value ? "YES" : "NO");
    }

    private void print(int value) {
        System.out.println(value);
    }

    private void print(long value) {
        System.out.println(value);
    }

    private void print(double value) {
        System.out.printf(Locale.ENGLISH, "%.10f", value);
    }

    private int[] getDigits(int number) {
        int[] digits = new int[10];
        int index = digits.length - 1;
        int digitsCount = 0;

        while (number > 0) {
            digits[index] = number % 10;
            number /= 10;
            index--;
            digitsCount++;
        }

        int[] result = new int[digitsCount];

        System.arraycopy(digits, digits.length - digitsCount, result, 0, digitsCount);

        return result;
    }

    private int[] readArray(Scanner scanner, int size) {
        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = scanner.nextInt();
        }

        return result;
    }

    private void readData() {
        Scanner scanner = new Scanner(System.in);

        s = scanner.next();
        n = scanner.nextInt();
    }

    private String solve() {
        s = s.toLowerCase();
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x < n + 97) {
                result = result + Character.toUpperCase(x);
            } else {
                result = result + Character.toLowerCase(x);
            }
        }

        return result;
    }
}
