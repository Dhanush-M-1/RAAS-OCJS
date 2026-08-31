import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 260B
 * θ(|s|) time
 * θ(|s|) space
 *
 * @author artyom
 */
public class _260B implements Runnable {
    private BufferedReader in;

    private Object solve() throws IOException {
        String s = nextToken() + "-";
        char[] d = new char[2], m = new char[2], y = new char[4];
        Map<Date, Integer> cnt = new HashMap<>();
        for (int i = 0, q = 0, n = s.length(); i < n; i++) {
            char c = s.charAt(i);
            switch (q) {
                case 0:
                    if (c != '-') {
                        d[0] = c;
                        q = 1;
                    }
                    break;
                case 1:
                    if (c == '-') {
                        q = 0;
                    } else {
                        d[1] = c;
                        q = 2;
                    }
                    break;
                case 2:
                    if (c == '-') {
                        q = 3;
                    } else {
                        d[0] = d[1];
                        d[1] = c;
                    }
                    break;
                case 3:
                    if (c == '-') {
                        q = 0;
                    } else {
                        m[0] = c;
                        q = 4;
                    }
                    break;
                case 4:
                    if (c == '-') {
                        q = 0;
                    } else {
                        m[1] = c;
                        q = 5;
                    }
                    break;
                case 5:
                    if (c == '-') {
                        q = 6;
                    } else {
                        d[0] = m[1];
                        d[1] = c;
                        q = 2;
                    }
                    break;
                case 6:
                    if (c == '-') {
                        q = 0;
                    } else {
                        y[0] = c;
                        q = 7;
                    }
                    break;
                case 7:
                    if (c == '-') {
                        q = 0;
                    } else {
                        y[1] = c;
                        q = 8;
                    }
                    break;
                case 8:
                    if (c == '-') {
                        d[0] = m[0];
                        d[1] = m[1];
                        m[0] = y[0];
                        m[1] = y[1];
                        q = 6;
                    } else {
                        y[2] = c;
                        q = 9;
                    }
                    break;
                case 9:
                    if (c == '-') {
                        d[0] = y[1];
                        d[1] = y[2];
                        q = 3;
                    } else {
                        y[3] = c;
                        q = 10;
                    }
                    break;
                case 10:
                    if (isCorrectDate(d, m, y)) {
                        Date date = new Date(d, m, y);
                        int val = cnt.getOrDefault(date, 0);
                        cnt.put(date, val + 1);
                    }
                    if (c == '-') {
                        d[0] = y[2];
                        d[1] = y[3];
                        q = 3;
                    } else {
                        d[0] = y[3];
                        d[1] = c;
                        q = 2;
                    }
                    break;
            }
        }
        Date maxDate = null;
        int max = 0;
        for (Map.Entry<Date, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() > max) {
                maxDate = entry.getKey();
                max = entry.getValue();
            }
        }
        return maxDate;
    }

    private static boolean isCorrectDate(char[] d, char[] m, char[] y) {
        if (y[0] != '2' || y[1] != '0' || y[2] != '1' || y[3] < '3' || y[3] > '5') {
            return false;
        }
        int month = Integer.parseInt("" + m[0] + m[1]);
        if (month < 1 || month > 12) {
            return false;
        }
        int x = 32, day = Integer.parseInt("" + d[0] + d[1]);
        if (month == 2) {
            x = 29;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            x = 31;
        }
        return day > 0 && day < x;
    }

    //--------------------------------------------------------------
    public static void main(String[] args) {
        new _260B().run();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(solve());
            in.close();
        } catch (IOException e) {
            System.exit(0);
        }
    }

    private String nextToken() throws IOException {
        return in.readLine();
    }

    private static final class Date {
        private final char[] day, month, year;

        private Date(char[] day, char[] month, char[] year) {
            this.day = Arrays.copyOf(day, 2);
            this.month = Arrays.copyOf(month, 2);
            this.year = Arrays.copyOf(year, 4);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Date date = (Date) o;

            return Arrays.equals(day, date.day) && Arrays.equals(month, date.month) && Arrays.equals(year, date.year);
        }

        @Override
        public int hashCode() {
            int result = Arrays.hashCode(day);
            result = 31 * result + Arrays.hashCode(month);
            result = 31 * result + Arrays.hashCode(year);
            return result;
        }

        @Override
        public String toString() {
            return "" + day[0] + day[1] + '-' + month[0] + month[1] + '-' + year[0] + year[1] + year[2] + year[3];
        }
    }
}