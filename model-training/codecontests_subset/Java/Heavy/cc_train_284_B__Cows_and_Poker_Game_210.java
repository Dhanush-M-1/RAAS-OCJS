import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);

        int n = sin.nextInt();
        sin.nextLine();
        String s = sin.nextLine();

        int count = 0;
        boolean one = false;
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (c=='I') {
                if (one) {
                    System.out.println('0');
                    return;
                }
                else one=true;
            }
            else if (c=='A') ++count;
        }
        if (one) System.out.println('1');
        else System.out.println(count);

        return;
    }
}
