import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by ishaykhiev2017 on 11.05.2018.
 */
public class Div3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        String n = sc.next();
        TreeMap<String, Integer> d = new TreeMap<>();
        for (int i = 0; i < n.length()-1; i++) {
            String k = n.substring(i, i + 2);
            if (d.containsKey(k)) {
                d.put(k, d.get(k) + 1);
            } else {
                d.put(k, 1);
            }
        }
        String answer = "";
        int max = -1;
        for (Map.Entry<String, Integer> entry: d.entrySet()) {
            if(max<entry.getValue()){
                answer = entry.getKey();
                max=entry.getValue();
            }
        }
        System.out.println(answer);
    }
}
