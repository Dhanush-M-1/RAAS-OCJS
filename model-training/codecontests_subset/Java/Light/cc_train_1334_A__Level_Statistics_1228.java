
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int count;
    static long sum;
    static boolean[][] checked;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        clears(scanner.nextInt());

    }


    public static void clears(int t) {
        int n, p,c, previousP, previousC;
        boolean ok;
        for (int i=0; i<t; i++){
            n = scanner.nextInt();
            ok = true;
            previousP=0;
            previousC=0;
            for (int j=0; j<n; j++){
                p = scanner.nextInt();
                c = scanner.nextInt();

                if (ok){
                    if (c>p || p<previousP || c<previousC || c - previousC > p -previousP ){
                        System.out.println("NO");
                        ok = false;
                    }
                }
                previousC = c;
                previousP =p;
            }
            if (ok){
                System.out.println("YES");
            }
        }
    }
}