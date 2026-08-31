import java.util.*;

class Main {

    static void printSeconds(int second) {
        int h = second / 3600;
        int m = (second / 60) % 60;
        int s = second % 60;

        System.out.printf("%02d:%02d:%02d\n", h, m, s);
    }

    static void solve (int h, int m, int s) {
        int second = h * 3600 + m * 60 + s;
        int rest = 7200 - second;

        printSeconds(rest);
        printSeconds(rest * 3);
    }

    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {
            int h = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();

            if (h == -1 && m == -1 && s == -1)  break;

            solve(h, m, s);
        }


    }
}