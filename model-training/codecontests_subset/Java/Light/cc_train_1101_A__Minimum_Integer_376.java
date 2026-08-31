import java.util.Scanner;

public class MinimumInteger {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int q = s.nextInt();
        int l = 0, r = 0, d = 0;
        for(int i = 0; i < q; i++) {
            l = s.nextInt();
            r = s.nextInt();
            d = s.nextInt();
            int x = 0;
            if(l > d) x = d;
            else if(d > r) x = d;
            else {
                int n = r / d;
                x = n * d;
                while(x <= r) x += d;
            }
            System.out.println(x);
        }
    }
}
