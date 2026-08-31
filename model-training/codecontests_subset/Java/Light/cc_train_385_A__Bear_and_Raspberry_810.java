import java.util.*;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();

        int pre = sc.nextInt();
        int max = 0;
        for (int i = 1; i < n; i++) {
            int d = sc.nextInt();
            if (pre-d-c > max)
                max = pre-d-c;
            pre = d;
        }



        System.out.println(max);
    }
}
