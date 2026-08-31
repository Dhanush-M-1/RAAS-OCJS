import java.util.Scanner;

/**
 * @author Mikhail Sedov [06.03.13 0:13]
 */
public class Problem168A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextInt();
        double x = in.nextInt();
        double y = in.nextInt();
        int clones = (int) Math.ceil(y * n / 100 - x);
        System.out.println(Math.max(0, clones));
    }
}
