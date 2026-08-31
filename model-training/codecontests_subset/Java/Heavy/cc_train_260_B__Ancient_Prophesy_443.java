import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AncientProphecySolver {

    private String s;

    public static void main(String[] args) {
        AncientProphecySolver solver = new AncientProphecySolver();

        solver.readData();
        String result = solver.solve();

        System.out.println(String.format("%s", result));
    }

    private String solve() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int max = -1;
        String result = "";

        for (int i = 0; i <= s.length() - 10; i++) {
            String date = s.substring(i, i + 10);

            if (!isCorrect(date)) {
                continue;
            }

            int count;
            if (!map.containsKey(date)) {
                map.put(date, 1);
                count = 1;
            } else {
                map.put(date, map.get(date) + 1);
                count = map.get(date);
            }

            if (count > max) {
                max = count;
                result = date;
            }
        }

        return result;
    }

    private boolean isCorrect(String date) {
        String[] parts = date.split("-");

        if (parts.length != 3) {
            return false;
        }
        if (parts[0].length() != 2 || parts[1].length() != 2 || parts[2].length() != 4) {
            return false;
        }

        int year = Integer.valueOf(parts[2]);
        int month = Integer.valueOf(parts[1]);
        int day = Integer.valueOf(parts[0]);

        if (year < 2013 || year > 2015) {
            return false;
        }
        if (month <= 0 || month > 12) {
            return false;
        }
        if (day <= 0) {
            return false;
        }

        if (month == 2 && day > 28) {
            return false;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return day <= 31;
        } else {
            return day <= 30;
        }
    }

    private void readData() {
        Scanner scanner = new Scanner(System.in);

        s = scanner.next();
    }
}