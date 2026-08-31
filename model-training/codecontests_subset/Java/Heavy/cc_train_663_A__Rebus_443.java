import java.util.Vector;
import java.util.Scanner;

public class Codeforces {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        char [] data = line.toCharArray();
        int n = Integer.parseInt(line.split("= ")[1]);

        Vector<Integer> order = new Vector<Integer>();
        for (int i = 0; i < data.length; ++i) {
            if (data[i] == '+')
                order.add(1);
            if (data[i] == '-')
                order.add(-1);
        }

        System.out.println();
        int [] max = new int[order.size()];
        int [] min = new int[order.size()];
        if (order.size() == 0) {
            System.out.println("Possible");
            System.out.print(n + " = " + n);
            return;
        }
        if (order.lastElement() == 1) {
            max[max.length - 1] = n - 1;
            min[max.length - 1] = 0;
        }
        else {
            max[max.length - 1] = n + n;
            min[max.length - 1] = n + 1;
        }

        for (int i = order.size() - 2; i >= 0; --i) {
            if (order.get(i) == -1) {
                min[i] = min[i + 1] + 1;
                max[i] = max[i + 1] + n;
            }
            if (order.get(i) == 1) {
                min[i] = min[i + 1] - n;
                max[i] = max[i + 1] - 1;
            }
        }

        if (max[0] <= 0 || min[0] > n) {
            System.out.println("Impossible");
            return;
        } else System.out.println("Possible");

        int delta = Math.max(1, min[0]);
        System.out.print(delta);
        int val = delta;
        for (int i = 0; i < order.size() - 1; ++i) {
            if (order.get(i) == 1) System.out.print(" + ");
            if (order.get(i) == -1) System.out.print(" - ");
            if (order.get(i) == 1) {
                delta = 1;
                while (val + delta < min[i + 1])
                    ++delta;
                System.out.print(delta);
                val += delta;
            }
            if (order.get(i) == -1) {
                delta = 1;
                while (val - delta > max[i + 1])
                    ++delta;
                System.out.print(delta);
                val -= delta;
            }
        }
        if (order.lastElement() == 1) System.out.print(" + ");
        if (order.lastElement() == -1) System.out.print(" - ");
        if (order.lastElement() == 1) System.out.print(n - val + " = " + n);
        if (order.lastElement() == -1) System.out.print(val - n + " = " + n);
    }
}
