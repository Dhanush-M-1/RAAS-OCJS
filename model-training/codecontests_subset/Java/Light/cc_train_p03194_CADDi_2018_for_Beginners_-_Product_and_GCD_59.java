import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long p = sc.nextLong();
        long ans = 1;
        Map<Long, Long> map = primeNumMap(p);
        for (Entry<Long, Long> entry : map.entrySet()) {
            long e = entry.getValue();
            if (e >= n) {
                long a = e / n;
                ans *= Math.pow(entry.getKey(), a);            }
        }

        System.out.println(ans);
    }

    //素因数分解してmapにわたす。
    static Map<Long, Long> primeNumMap(long m) {
        Map<Long, Long> map = new HashMap<>();
        for (long i = 2; i <= m; i++) {

            if (m % i == 0) {
                while (m % i == 0) {
                    m /= i;
                    if (m == 1) {
                        if (map.containsKey(i)) {
                            map.put(i, map.get(i) + 1);
                        } else {
                            map.put(i, 1l);
                        }
                        return map;

                    } else {
                        if (map.containsKey(i)) {
                            map.put(i, map.get(i) + 1);
                        } else {
                            map.put(i, 1l);
                        }
                    }
                }
                if (isPrimeNum(m)) {
                    if (map.containsKey(m)) {
                        map.put(m, map.get(m) + 1);
                    } else {
                        map.put(m, 1l);
                    }
                    return map;
                }
            }

        }
        return map;
    }

    static boolean isPrimeNum(long m) {
        boolean ans = true;
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (m % i == 0) {
                return false;
            }
        }
        return ans;
    }

}