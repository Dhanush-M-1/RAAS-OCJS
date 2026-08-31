
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gargon
 */
public class JavaApplication41 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Pattern p = Pattern.compile("(\\d\\d)-(\\d\\d)-(\\d\\d\\d\\d)");
        Map dates = new HashMap();
        int[] md = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 0; i < str.length() - 9; i++) {
            String date = str.substring(i, i + 10);
            Matcher matcher = p.matcher(date);
            while (matcher.find()) {
                int d = Integer.parseInt(matcher.group(1));
                int m = Integer.parseInt(matcher.group(2));
                int y = Integer.parseInt(matcher.group(3));
                if (y >= 2013 && y <= 2015) {
                    if (m > 0 && m <= 12) {
                        if (d > 0 && d <= md[m-1]) {
                            int num = 0;
                            if (dates.containsKey(date)) {
                                num = (int) dates.get(date);
                            }
                            dates.put(date, ++num);
                        }
                    }
                }
            }
        }

        int max = 0;
        String result = null;
        Iterator it = dates.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pairs = (Map.Entry) it.next();
            if ((int) pairs.getValue() > max) {
                max = (int) pairs.getValue();
                result = (String) pairs.getKey();
            }
        }
        System.out.println(result);
    }
}
