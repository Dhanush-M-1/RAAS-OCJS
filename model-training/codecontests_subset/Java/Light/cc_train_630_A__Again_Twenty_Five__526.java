import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        if (Integer.MAX_VALUE < t) {
            System.out.println(25);
        } else {
            int result = (int) ((Math.pow(5, t)) % 100);
            System.out.println(result);
        }
    }
}
