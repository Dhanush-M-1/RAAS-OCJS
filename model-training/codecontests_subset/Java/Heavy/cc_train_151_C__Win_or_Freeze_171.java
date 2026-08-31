import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author koponk
 */
public class soalC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        if (n == 1 || isPrim(n)) {
            System.out.println("1");
            System.out.println("0");
        } else {
            boolean win = find(n);
            if (win) {
                System.out.println("2");
            } else {
                System.out.println("1");
                ArrayList<Long> data = new ArrayList<Long>();
                long a = 2L;
                for (a = 2L; a * a < n; a += 1L) {
                    if (n % a == 0) {
                        data.add(a);
                        data.add(n / a);
                    }
                }
                if (a * a == n) {
                    data.add(a);
                }
                for (int ax = 0; ax < data.size(); ax++) {
                    if (find(data.get(ax))) {
                        System.out.println(data.get(ax));
                        ax = data.size();
                    }
                }
            }
        }
    }
    
    private static boolean find(long n) {
        if (isPrim(n)) {
            return false;
        }
        ArrayList<Long> data = new ArrayList<Long>();
        long a = 2L;
        for (a = 2L; a * a < n; a += 1L) {
            if (n % a == 0) {
                data.add(a);
                data.add(n / a);
            }
        }
        if (a * a == n) {
            data.add(a);
        }
        for (int ax = 0; ax < data.size(); ax++) {
            if (!isPrim(data.get(ax))) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isPrim(long n) {
        if (n <= 1L) {
            return false;
        }
        if (n == 2L) {
            return true;
        }
        if (n % 2L == 0) {
            return false;
        }
        for (long a = 3L; a * a <= n; a += 1L) {
            if (n % a == 0) {
                return false;
            }
        }
        return true;
    }
}
