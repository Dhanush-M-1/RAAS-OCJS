import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int h = a;
        int w = a;
        while (w >= b) {
            h = h + w / b;
            w = w % b + w / b;
        }
        System.out.println(h);
        sc.close();
    }
}