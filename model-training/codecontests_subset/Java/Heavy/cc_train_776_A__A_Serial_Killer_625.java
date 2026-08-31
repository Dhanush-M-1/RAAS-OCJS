import java.util.Scanner;

/**
 * Created by yuu on 8/4/17.
 */
public class Problem776A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] victims = new String[2];
        victims[0] = sc.next();
        victims[1] = sc.next();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(victims[0] + " " + victims[1]);
            String dead = sc.next();
            String replacement = sc.next();
            if (dead.equals(victims[0])) {
                victims[0] = replacement;
            }
            else {
                victims[1] = replacement;
            }
        }
        System.out.println(victims[0] + " " + victims[1]);
    }

}
