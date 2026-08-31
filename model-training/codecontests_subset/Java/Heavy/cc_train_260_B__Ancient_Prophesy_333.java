import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AncientProphesy {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String line = in.next();
        Pattern pattern = Pattern.compile("(\\d){2}-(\\d){2}-(\\d){4}");
        Matcher matcher = pattern.matcher(line);

        Map<String, Integer> dates = new HashMap<String, Integer>();

        int offset = 0, max = 0;
        String result = "";

        int[] datear = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while (matcher.find(offset)) {
            String date = matcher.group();
            offset = matcher.start() + 8;

            String[] split = date.split("-");
            int dd = Integer.parseInt(split[0]);
            int mm = Integer.parseInt(split[1]);
            int yy = Integer.parseInt(split[2]);

            if (!(mm >= 1 && mm <= 12 && (yy >= 2013 && yy <= 2015) && dd >= 1 && dd <= datear[mm-1])) continue;

            if (!dates.containsKey(date)) dates.put(date, 0);
            dates.put(date, dates.get(date) + 1);

            if (max < dates.get(date)) {
                max = dates.get(date);
                result = date;
            }
        }
        out.println(result);
        out.close();
    }
}
