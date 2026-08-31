import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rects = 0;
        int rhombus = 0;
        while (sc.hasNext()) {
            String s = sc.next();

            int a = Integer.parseInt(s.split(",")[0]);
            int b = Integer.parseInt(s.split(",")[1]);
            int c = Integer.parseInt(s.split(",")[2]);

            if (a == b) {
                rhombus++;
            } else if (a * a + b * b == c * c) {
                rects++;
            }
        }

        System.out.println(rects);
        System.out.println(rhombus);
    }
}