
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author izharishaksa
 */
public class AandBandCompilationErrors {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] number = new int[N];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
            number[i] = x;
        }
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        int[] number2 = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            int x = sc.nextInt();
            map.put(x, map.get(x) - 1);
            if (map2.containsKey(x)) {
                map2.put(x, map2.get(x) + 1);
            } else {
                map2.put(x, 1);
            }
            number2[i] = x;
        }
        for (int i = 0; i < N; i++) {
            int x = map.get(number[i]);
            if (x == 1) {
                System.out.println(number[i]);
                break;
            }
        }
        for (int i = 0; i < N - 2; i++) {
            int x = sc.nextInt();
            map2.put(x, map2.get(x) - 1);
        }
        for (int i = 0; i < N - 1; i++) {
            int x = map2.get(number2[i]);
            if (x == 1) {
                System.out.println(number2[i]);
                break;
            }
        }
    }
}
