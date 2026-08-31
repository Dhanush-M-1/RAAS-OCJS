
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        int[] M = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String max = "";
        HashMap<String, Integer> H = new HashMap<String, Integer>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            if (s.charAt(i + 2) != '-' || s.charAt(i + 5) != '-')
                continue;
            try {
                int day = Integer.parseInt(s.substring(i, i + 2));
                int month = Integer.parseInt(s.substring(i + 3, i + 5));
                int year = Integer.parseInt(s.substring(i + 6, i + 10));
                if (year < 2013 || year > 2015)
                    continue;
                if (month < 1 || month > 12)
                    continue;
                if (day < 1 || day > M[month - 1])
                    continue;
                String temp = s.substring(i, i + 10);
                if (!H.containsKey(temp))
                    H.put(temp, 1);
                else
                    H.put(temp, H.get(temp) + 1);
                if (!H.containsKey(max) || H.get(temp) > H.get(max))
                    max = temp;
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println(max);
    }
}
