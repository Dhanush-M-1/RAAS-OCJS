import java.util.Scanner;

/**
 * Created by DQ-PC on 23.02.2017.
 */
public class A4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] first = in.nextLine().split("\\s+");
        int n = in.nextInt();
        in.nextLine();
        String[] all = new String[n];
        for (int i = 0; i < n; ++i) {
            all[i] = in.nextLine();
        }
        System.out.println(first[0] + " " + first[1]);
        for (int i = 0; i < n; ++i) {
            String[] values = all[i].split("\\s+");

            if (first[0].equals(values[0])) {
                System.out.println(first[1] + " " + values[1]);
                first[0] = values[1];
            } else {
                System.out.println(first[0] + " " + values[1]);
                first[1] = values[1];
            }
        }
    }
}
