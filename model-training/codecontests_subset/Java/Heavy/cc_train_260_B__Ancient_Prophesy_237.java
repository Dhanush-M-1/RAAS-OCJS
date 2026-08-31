import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class TaskB {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);

        String s = input.readLine();
        int pos = 0;

        Map<String, Integer> result = new HashMap<String, Integer>();

        int[] days = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        while (true) {
            if (s.length() - pos < 10) break;

            if (s.charAt(pos + 2) == '-' &&
                    s.charAt(pos + 5) == '-' &&
                    s.charAt(pos + 6) == '2' &&
                    s.charAt(pos + 7) == '0' &&
                    s.charAt(pos + 8) == '1' &&
                    (s.charAt(pos) >= '0' && s.charAt(pos) <= '3') &&
                    (s.charAt(pos+1) >= '0' && s.charAt(pos+1) <= '9') &&
                    (s.charAt(pos+3) >= '0' && s.charAt(pos+3) <= '1') &&
                    (s.charAt(pos+4) >= '0' && s.charAt(pos+4) <= '9') &&
                    (s.charAt(pos+9) >= '3' && s.charAt(pos+9) <= '5')) {
                //possible date
                String day_s = "" + s.charAt(pos) + s.charAt(pos + 1);
                int day = Integer.parseInt(day_s, 10);

                String month_s = "" + s.charAt(pos + 3) + s.charAt(pos + 4);
                int month = Integer.parseInt(month_s, 10);

                int year = Integer.parseInt("201" + s.charAt(pos + 9), 10);

                if (month > 0 && month < 13 && day >0 && day <= days[month-1] && year > 2012 && year < 2016) {
                    String date = day_s + "-" + month_s + "-" + year;
                    //String date = day + "-" + month + "-" + year;
                    if (result.containsKey(date)) {
                        result.put(date, result.get(date) + 1);
                    } else {
                        result.put(date, 1);
                    }
                }
            }
            pos++;
        }

        int max = 0;
        String dateOut = "";
        for (Map.Entry<String, Integer> entry: result.entrySet()) {
            if (entry.getValue() > max) {
                dateOut = entry.getKey();
                max = entry.getValue();
            }
        }

        output.write(dateOut);
        output.close();
	}

}
