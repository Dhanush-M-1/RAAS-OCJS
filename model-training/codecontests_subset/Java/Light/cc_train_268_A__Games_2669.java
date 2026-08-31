import java.util.Scanner;
 
public class Traning3 {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h[] = new int[101];
        int g[] = new int[101];
        int t = in.nextInt();
        while (t-- > 0) {
            h[in.nextInt()]++;
            g[in.nextInt()]++;
        }
        int sum = 0;
        for (int i = 0; i < 101; i++) {
                sum += (h[i] * g[i]);
        }
        System.out.println(sum);
    }
 
}