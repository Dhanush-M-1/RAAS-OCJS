import java.util.ArrayList;
import java.util.Scanner;

public class Bricks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String[] qus = new String[n];
            for (int i = 0; i < n; i++) {
                qus[i] = in.next();
            }
            ArrayList<Pair> list = new ArrayList<>(2);
            int x = Character.getNumericValue(qus[0].charAt(1));
            int y = Character.getNumericValue(qus[1].charAt(0));
            int a = Character.getNumericValue(qus[n - 2].charAt(n - 1));
            int b = Character.getNumericValue(qus[n - 1].charAt(n - 2));
            int[] nums = new int[4];
            nums[0] = x;
            nums[1] = y;
            nums[2] = a;
            nums[3] = b;
            if (x == y) {
                if (a == x) {
                    list.add(new Pair(n - 2, n - 1));
                }
                if (b == x) {
                    list.add(new Pair(n - 1, n - 2));
                }
            } else if (a == b) {
                if (a == x) {
                    list.add(new Pair(0, 1));
                }
                if (a == y) {
                    list.add(new Pair(1, 0));
                }
            } else {
                if (x != 0) {
                    list.add(new Pair(0, 1));
                }
                if (y != 0) {
                    list.add(new Pair(1, 0));
                }
                if (a != 1) {
                    list.add(new Pair(n - 2, n - 1));
                }
                if (b != 1) {
                    list.add(new Pair(n - 1, n - 2));
                }
            }
            System.out.println(list.size());
            for (Pair pair : list) {
                System.out.println((pair.a + 1) + " " + (pair.b + 1));
            }
        }
    }
}
class Pair {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}
