import java.util.Scanner;

/**
 * Created by igarus on 17.10.2016.
 */
public class CF_438_A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        String[] A = new String[n];
        boolean result = false;
        for (int i = 0; i < n; i++) {
            A[i] = scanner.next();
            if (A[i].equals(s))
                result = true;
        }
        if (result)
            System.out.println("YES");
        else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (s.equals(A[i].charAt(1) + "" + A[j].charAt(0))) {
                        result = true;
                        break;
                    }
                }
                if (result)
                    break;
            }
            System.out.println(result ? "YES" : "NO");
        }
    }

}
