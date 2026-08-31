import java.util.Scanner;

public class task851b {

    void run() {
        Scanner sc = new Scanner(System.in);
        long ax = sc.nextInt();
        long ay = sc.nextInt();
        long bx = sc.nextInt();
        long by = sc.nextInt();
        long cx = sc.nextInt();
        long cy = sc.nextInt();
        long ab = (bx - ax) * (bx - ax) + (by - ay) * (by - ay);
        long bc = (bx - cx) * (bx - cx) + (by - cy) * (by - cy);

        if (ab == bc && (by - ay) * (cx - ax) != (cy - ay) * (bx - ax)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        new task851b().run();
    }

}
