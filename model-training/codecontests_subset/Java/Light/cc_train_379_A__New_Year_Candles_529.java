import java.util.Scanner;

/**
 * Created by AdminPC on 06.02.2017.
 */
public class bin {
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(n + (n-1)/(k-1));

    }
}