import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        A problem = new A();
        problem.solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int d1 = sc.nextInt();
        int d2 = sc.nextInt();

        int a, b, c, d;
        if(r1 < 3 || r2 < 3 || c1 <3 || c2 < 3 || d1 < 3 || d2 < 3 ){
            System.out.print(-1);
            return;
        }
        for (int i = 1; i < 10; i++) {
            a = i;
            b = r1 - i;
            if (b < 10 && a != b) {
                for (int j = 1; j < 10; j++) {
                    c = j;
                    d = r2 - j;
                    if (d < 10 && c != d && c != a && c!= b && d!=a && d!=b) {
                        if (a + c == c1 && b + d == c2 && a + d == d1
                                && b + c == d2) {
                            System.out.println(a + "  " + b);
                            System.out.print(c + "  " + d);
                            return;
                        }
                    }
                }
            }
        }
        System.out.print(-1);

    }
}