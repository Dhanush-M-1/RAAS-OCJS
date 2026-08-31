

import java.util.Scanner;

public class Equation20B {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in[] = scan.nextLine().split(" ");
        solve(Integer.parseInt(in[0]), Integer.parseInt(in[1]), Integer.parseInt(in[2]));
    }

    public static void solve(int a, int b, int c) {
        if (a == 0 && b == 0 && c == 0) {
            System.out.println(-1);
            return;
        }

        double fa = a;
        double fb = b;
        double fc = c;

        double root = -fc / fa + fb * fb / (4 * fa * fa);
        double add = -fb / (2 * fa);

        if (root < 0 || (a == 0 && b == 0 & c != 0)) {
            System.out.println("0");
            return;
        }

        if (root == 0) {
            System.out.println("1");
            System.out.println(add);
            return;
        }
        
        if (a == 0) {
            System.out.println("1");
            System.out.println(-fc / fb);
            return;
        }

        System.out.println("2");
        System.out.println(-Math.sqrt(root) + add);
        System.out.println(+Math.sqrt(root) + add);
    }
}
