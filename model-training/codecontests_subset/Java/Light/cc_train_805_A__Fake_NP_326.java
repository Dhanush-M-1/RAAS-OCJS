import java.util.Scanner;

/**
 * Created by TU on 30/6/2017.
 */
public class Problem805A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        if (l == r && l % 2 == 1) System.out.println(r);
        else System.out.println(2);
    }
}
