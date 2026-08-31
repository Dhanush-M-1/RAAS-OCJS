import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pn = new int[n+1];
        for (int i = 1; i <= n; i++) {
            pn[i] = sc.nextInt();
        }

        int sw = 0;
        for (int i = 1; i <= n; i++) {
            if (pn[i] == i) {
                if (i != n) {
                    int t = pn[i];
                    pn[i] = pn[i+1];
                    pn[i+1] = t;
                }
                sw += 1;
            }
        }

        System.out.println(sw);
    }

}