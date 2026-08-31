import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] r = { s.nextInt(), s.nextInt() }, c = { s.nextInt(), s.nextInt() }, d = {
                s.nextInt(), s.nextInt() };
        Integer[] a = new Integer[4];
        for (a[0] = 1; a[0] < 10; ++a[0]) {
            for (a[1] = 1; a[1] < 10; ++a[1]) {
                for (a[2] = 1; a[2] < 10; ++a[2]) {
                    for (a[3] = 1; a[3] < 10; ++a[3]) {
                        if (a[0] + a[1] == r[0] && a[2] + a[3] == r[1]) {
                            if (a[0] + a[2] == c[0] && a[1] + a[3] == c[1]) {
                                if (a[0] + a[3] == d[0] && a[1] + a[2] == d[1]) {
                                    if (new HashSet<Integer>(Arrays.asList(a)).size() == 4) {
                                        System.out.println(a[0] + " " + a[1]);
                                        System.out.println(a[2] + " " + a[3]);
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}