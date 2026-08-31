import java.util.*;
import static java.lang.Math.*;
/**
 * @author 彭豪杰
 * @date 2020/7/20 0020
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static int getInt(){
        return scanner.nextInt();
    }

    public static void solve() {
        int n = getInt();
        int k = getInt();
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        int time,k1,k2;
        for (int i = 0; i < n; i++) {
            time = getInt();
            k1 = getInt();
            k2 = getInt();
            if (k1 == 1 && k2 == 1) {
                l3.add(time);
            } else if (k1 == 1) {
                l1.add(time);
            } else if (k2 == 1) {
                l2.add(time);
            }
        }
        Collections.sort(l1);
        Collections.sort(l2);
        Collections.sort(l3);
        Queue<Integer> q1 = new LinkedList<>(l1);
        Queue<Integer> q2 = new LinkedList<>(l2);
        Queue<Integer> q3 = new LinkedList<>(l3);
        if (min(l1.size() + l3.size(), l2.size() + l3.size()) < k) {
            System.out.println(-1);
            return;
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (q1.isEmpty() || q2.isEmpty()) {
                res += q3.remove();
            } else if (q3.isEmpty()) {
                res += q1.remove() + q2.remove();
            } else {
                if ((q1.element() + q2.element()) < q3.element()) {
                    res += q1.remove() + q2.remove();
                }else {
                    res += q3.remove();
                }
            }
        }
        System.out.println(res);

    }

    public static void main(String[] args) {
        solve();
    }
}
