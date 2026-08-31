import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class D1213 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int n=0; n<N; n++) {
            int a = in.nextInt();
            int step = 0;
            while (true) {
                List<Integer> list = map.get(a);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(a, list);
                }
                list.add(step);
                step++;
                if (a == 0) {
                    break;
                } else {
                    a /= 2;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            if (list.size() >= K) {
                Collections.sort(list);
                int count = 0;
                for (int i=0; i<K; i++) {
                    count += list.get(i);
                }
                min = Math.min(min, count);
            }
        }
        System.out.println(min);
    }

}
