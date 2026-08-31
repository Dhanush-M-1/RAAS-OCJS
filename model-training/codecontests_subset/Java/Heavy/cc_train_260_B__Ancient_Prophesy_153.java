import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {
        Pattern pat = Pattern.compile("\\d\\d-\\d\\d-\\d\\d\\d\\d");
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line = buf.readLine();
        Matcher mat = pat.matcher(line);
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        String res = null;
        int maxc = 0;
        int index = 0;
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        while (mat.find(index)) {
            String g = mat.group();
            index = mat.start() + 1;
            int day = Integer.parseInt(g.substring(0, 2));
            int month = Integer.parseInt(g.substring(3, 5));
            int year = Integer.parseInt(g.substring(6));
            if (year < 2013 || year > 2015)
                continue;
            if (month < 1 || month > 12)
                continue;
            if (day < 1 || day > months[month])
                continue;
            if (res == null) res = g;
            if (count.containsKey(g)) {
                int c = count.get(g) + 1;
                if (c > maxc) {
                    maxc = c;
                    res = g;
                }
                count.put(g, c);
            }
            else count.put(g, 1);
        }
        System.out.println(res);
    }
}
