import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String pass, s;
        pass = in.next();
        int n = in.nextInt();
        char a, b, x, y;
        a = pass.charAt(0);
        b = pass.charAt(1);

        int t, p;
        t = p = 0;

        for(int i = 1; i <= n; i++) {
            s = in.next();
            x = s.charAt(0);
            y = s.charAt(1);
            if(x == a && y == b)
            {
                System.out.print("YES");
                System.exit(0);
            }

            if(x == b)
                t++;
            if(y == a)
                p++;
        }

        if(t > 0 && p > 0)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}