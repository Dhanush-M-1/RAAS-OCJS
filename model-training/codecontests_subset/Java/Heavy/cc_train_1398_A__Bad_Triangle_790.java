import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int x = 0;
            int y = 0;
            int z = 0;
            for (int i=0; i<n; i++) {
                if (i==0) {
                    x = scanner.nextInt();
                } else if (i == n-1) {
                    z = scanner.nextInt();
                } else if (i == 1) {
                    y = scanner.nextInt();
                } else {
                    scanner.nextInt();
                }
            }
            if (x+y > z && y+z > x && z+x > y)
                System.out.println(-1);
            else
                System.out.println(1 + " " + 2 + " " + n);
        }
    }

}