import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0;i < str.length() - 1;i++)
            if(map.containsKey(str.substring(i, i + 2)))
                map.put(str.substring(i, i + 2), map.get(str.substring(i, i + 2)) + 1);
            else
                map.put(str.substring(i, i + 2), 1);

        int sum = 0;

        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() > sum) {
                sum = entry.getValue();
                str = entry.getKey();
            }
        }

        System.out.println(str);
    }
}
