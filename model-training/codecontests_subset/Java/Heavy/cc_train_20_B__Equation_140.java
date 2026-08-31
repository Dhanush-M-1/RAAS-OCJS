import java.util.Arrays;
import java.util.Scanner;


public class R020B {
    public void debug(Object... objects) { System.err.println(Arrays.deepToString(objects)); }
    
    long a, b, c;
    
    public R020B() {
        Scanner scanner = new Scanner(System.in);
        this.a = scanner.nextLong();
        this.b = scanner.nextLong();
        this.c = scanner.nextLong();
    }
    
    private void process() {
        if(a ==0 && b ==0) { 
            if(c == 0) { System.out.println(-1); }
            else System.out.println(0);
        } else if (a == 0) {
            System.out.println(1);
            System.out.println((-c + 0.) / b);
        } else {
            long d = b*b - 4*a*c;
            if(d < 0) { System.out.println(0); return; }
            if(d == 0) {
                System.out.println(1);
                System.out.println((-b + 0.) / (2*a)); 
                return;
            }
            double[] ans = new double[2];
            ans[0] = (-b + Math.sqrt(d)) / (2*a);
            ans[1] = (-b - Math.sqrt(d)) / (2*a);
            Arrays.sort(ans);
            System.out.println(2);
            System.out.println(ans[0]);
            System.out.println(ans[1]);
        }
    }
    
    public static void main(String[] args) { new R020B().process(); }
}
