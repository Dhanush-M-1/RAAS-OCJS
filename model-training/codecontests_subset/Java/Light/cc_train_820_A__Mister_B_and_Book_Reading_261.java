import java.util.Scanner;

/**
 * Created by phuoc on 6/27/17.
 */
public class MisterB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c, v0, v1, a, l;
        c = in.nextInt();
        v0 = in.nextInt();
        v1 = in.nextInt();
        a = in.nextInt();
        l = in.nextInt();

        int count = 1;
        while (c > v0) {
            c = c - (v0 + a * count < v1 ? v0 + a * count : v1) + l;
            count++;
        }
        System.out.println(count);
    }
}
