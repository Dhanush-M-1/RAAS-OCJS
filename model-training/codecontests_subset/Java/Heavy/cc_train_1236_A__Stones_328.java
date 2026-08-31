import java.util.*;
public class Stone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int count =0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            while (true) {
                if (b >= 1 && c >= 2) {
                    count += 1;
                    b -= 1;
                    count += 2;
                    c -= 2;
                }
                else if (a >= 1 && b >= 2) {
                    count += 1;
                    a -= 1;
                    count += 2;
                    b -= 2;
                }

                else break;
            }
            System.out.println(count);


        }

    }
}
