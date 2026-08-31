import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        Map<String, Integer> map = new HashMap<>();
        char[] str = sc.next().toCharArray();
        for (int i = 1; i < str.length; i++) {
            String s = String.valueOf(str[i - 1]) + String.valueOf(str[i]);
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }
        Map.Entry<String, Integer> maxEntry = (Map.Entry<String, Integer>) map.entrySet().toArray()[0];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (maxEntry.getValue() < entry.getValue())
                maxEntry = entry;

        }
        System.out.println(maxEntry.getKey());
    }

}
