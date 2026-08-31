import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Слава
 *
 */
public class Codeforces {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeMap<Integer, Integer> ints = new TreeMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            ints.putIfAbsent(tmp, 0);
            ints.put(tmp, ints.get(tmp) + 1);
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (Integer i : ints.keySet()) {
            arr.add(i);
        }
        int ans = 0;
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(i - 1) && arr.get(i) <= arr.get(i - 1) + k) {
                ans += ints.get(arr.get(i - 1));
            }
        }
        System.out.println(n - ans);
    }
}
