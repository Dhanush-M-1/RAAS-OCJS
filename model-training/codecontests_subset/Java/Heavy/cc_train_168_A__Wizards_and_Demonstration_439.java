
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author koponk
 */
public class soalA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input[] = in.nextLine().split(" ");
        int data[] = new int[3];
        for (int a = 0; a < 3; a++) {
            data[a] = Integer.parseInt(input[a]);
        }
        double hasil = (((double) data[2] * (double) data[0] - 100.0 * (double) data[1]) / 100.0);
        if (hasil < 0) {
            System.out.println("0");
        } else {
            System.out.println((int) (Math.ceil(hasil)));
        }
    }
}
