import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(), Sn = 0, max = 0;
        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            if (a>max){max=a;}
            Sn+=a;
        }

        System.out.println(Math.max((2*Sn/n)+1, max));
    }
}
