import java.util.Scanner;
 
public class A1236 {
 
    public static void main(String args[]) {
 
        Scanner ad = new Scanner(System.in);
 
        int n = ad.nextInt();
        int a = 0, b = 0, c = 0;
 
        for (int i = 0; i < n; i++) {
            a = ad.nextInt();
            b = ad.nextInt();
            c = ad.nextInt();
            int s = 0;
            s += Math.min(c/2, b);
            b -= Math.min(c/2, b);
            s += Math.min(a, b/2);
            a -= Math.min(a, b/2);
            System.out.println(s * 3);
        }
 
 
    }
}