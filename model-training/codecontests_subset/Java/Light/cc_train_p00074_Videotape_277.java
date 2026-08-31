import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int h;
    static int w;
    static int c;
    static int ans;
    static int count;
    static int[] color_order;
    static int[][] map;
    static int[][] tmp;

    public static void main(String[] args) throws java.io.IOException {

        Scanner sc = new Scanner(System.in);
        while (true) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            if (h == -1 && m == -1 && s == -1)
                break;
            int sum = 3600 * h + 60 * m + s;
            {
                int rest = 7200 - sum;
                int nh = rest / 3600;
                rest %= 3600;
                int nm = rest / 60;
                rest %= 60;
                int ns = rest;
                System.out.printf("%02d:%02d:%02d\n", nh, nm, ns);
            }
            {
                int rest = 7200 - sum;
                rest *= 3;
                int nh = rest / 3600;
                rest %= 3600;
                int nm = rest / 60;
                rest %= 60;
                int ns = rest;
                System.out.printf("%02d:%02d:%02d\n", nh, nm, ns);
            }
        }
    }
}