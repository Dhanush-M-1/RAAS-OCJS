import java.util.*;
public class A1043 {

    public static void main(String[] args) {
        Scanner f = new Scanner(System.in);
        int n = f.nextInt();
        int k = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            int ai = f.nextInt();
            k = Math.max(k, ai); sum += ai;
        }
//        System.out.println(k + " " +  sum);
        System.out.println(Math.max(k, 2 * sum / n + 1));
    }
}
