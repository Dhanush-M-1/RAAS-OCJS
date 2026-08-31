import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int w = 0;
        while (!check(a,b,c,w*b))
            w++;

        System.out.println(w);
    }

    private static boolean check(int a, int b, int c, int d)
    {
        for (int i = 1; i <= c; i++) {
            if (d+i*b < a*i)
                return false;
        }

        return true;
    }
}
