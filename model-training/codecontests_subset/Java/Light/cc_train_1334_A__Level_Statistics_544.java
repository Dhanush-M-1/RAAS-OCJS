import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int cases = scan.nextInt();
        int n, p, c;
        int lastP, lastC;
        boolean possible;

        for (int i = 0; i < cases; i++) {
            n = scan.nextInt();
            possible = true;
            lastP = lastC = -1;
            for (int j = 0; j < n; j++) {
                p = scan.nextInt();
                c = scan.nextInt();
                if(p - lastP < 0 || c - lastC < 0 || (p - lastP < c - lastC))
                    possible = false;
                lastP = p;
                lastC = c;
            }
            if(!possible) System.out.println("NO");
            else System.out.println("YES");
        }

    }
}
