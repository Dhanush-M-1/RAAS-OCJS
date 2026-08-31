import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        HashMap<Character, Integer> set = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (!set.containsKey(c)) {
                set.put(c, i + 1);
            }
            for (Map.Entry<Character, Integer> entry : set.entrySet()) {
                if (entry.getKey() > c) {
                    System.out.println("YES");
                    System.out.println(entry.getValue() + " " + (i + 1));
                    System.exit(0);
                }
            }
        }

        System.out.println("NO");
    }

}