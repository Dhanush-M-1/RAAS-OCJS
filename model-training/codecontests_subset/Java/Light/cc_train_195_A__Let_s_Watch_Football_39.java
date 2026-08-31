
import java.util.*;

public class Solver {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int x = c * a;
        int n = b;
        while (n < x) {
            list.add(n);
            n += b;
        }
        System.out.println(list.size() - c + 1);
    }
}