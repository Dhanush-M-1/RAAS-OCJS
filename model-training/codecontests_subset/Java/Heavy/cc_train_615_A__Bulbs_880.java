import java.util.*;

public class Bulbs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfButtons = sc.nextInt();
        int numOfBulbs = sc.nextInt();

        boolean[] bulbStatus = new boolean[numOfBulbs];

        for (int i = 0; i < numOfButtons; i++) {
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                bulbStatus[sc.nextInt()-1] = true;
            }
        }

        boolean on = true;
        for (boolean b : bulbStatus) {
            on = on && b;
        }

        if (on) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}