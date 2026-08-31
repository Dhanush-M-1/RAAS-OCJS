import java.util.*;

/**
 * Created by Szymon_2 on 2016-05-05.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int roads = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        if (roads - cities < 1) {
            System.out.println(-1);
            return;
        }
        if(cities == 4) {
            System.out.println(-1);
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= cities; i++) {
            if (i != A && i != B && i != C && i != D) {
                list.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer city : list) {
            sb.append(city + " ");
        }

        String middle = sb.toString();

        System.out.println(A + " " + C + " " + middle + D + " " + B);
        System.out.println(C + " " + A + " " + middle + B + " " + D);

    }
}
