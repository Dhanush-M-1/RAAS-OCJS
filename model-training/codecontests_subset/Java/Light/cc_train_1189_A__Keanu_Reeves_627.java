import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class Main {
    public static void main(String[] args) {
        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int size = Integer.parseInt(br.readLine());
            final String line = br.readLine();
            if (size % 2 != 0 || isGoodNumber(size, line)) {
                System.out.println(1);
                System.out.println(line);
            } else {
                printGoodNumber(size, line);
            }
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    private static boolean isGoodNumber(int size, String line) {
        int count = 0;
        for (int i = 0; i < size; ++i) {
            if (line.charAt(i) == '0') {
                ++count;
            }
        }
        return count != (size >> 1);
    }

    private static void printGoodNumber(int size, String line) {
        System.out.println(2);
        System.out.printf("%c ", line.charAt(0));
        for (int i = 1; i < size; ++i) {
            System.out.print(line.charAt(i));
        }
    }
}