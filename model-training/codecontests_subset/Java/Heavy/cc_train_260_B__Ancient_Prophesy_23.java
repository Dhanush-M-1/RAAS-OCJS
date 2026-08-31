//package codeforces;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class B implements Closeable {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter writer = new PrintWriter(System.out);
    StringTokenizer stringTokenizer;

    B() throws IOException {
//        reader = new BufferedReader(new FileReader("cycle2.in"));
//        writer = new PrintWriter(new FileWriter("cycle2.out"));
    }

    String next() throws IOException {
        while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
            stringTokenizer = new StringTokenizer(reader.readLine());
        }
        return stringTokenizer.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    final int MOD = 1000 * 1000 * 1000 + 9;

    int sum(int a, int b) {
        a += b;
        return a >= MOD ? a - MOD : a;
    }

    int product(int a, int b) {
        return (int) (1l * a * b % MOD);
    }

    @SuppressWarnings("unchecked")
    void solve() throws IOException {
        final String dateFormat = "dd-MM-yyyy";
        final Map<String, Integer> counter = new HashMap<>();
        class Utils {
            String r = "[\\d]{2,2}-[\\d]{2,2}-[\\d]{4,4}";
            SimpleDateFormat format = new SimpleDateFormat(dateFormat);
            {
                format.setLenient(false);
            }
            boolean correctDate(String date) {
                try {
                    if(!date.matches(r)) {
                        return false;
                    }
                    Calendar calendar = new GregorianCalendar();
                    calendar.setTime(format.parse(date));
                    final int year = calendar.get(Calendar.YEAR);
                    return year >= 2013 && year <= 2015;
                } catch(Exception e) {
                    return false;
                }
            }
            void processDate(String date) {
                if(correctDate(date)) {
                    Integer value = counter.get(date);
                    if(value == null) {
                        value = 0;
                    }
                    counter.put(date, value + 1);
                }
            }
        }
        Utils utils = new Utils();
        String input = next();
        for(int i = 0; i + dateFormat.length() <= input.length(); i++) {
            utils.processDate(input.substring(i, i + dateFormat.length()));
        }
        String answer = counter.keySet().iterator().next();
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > counter.get(answer)) {
                answer = entry.getKey();
            }
        }
        writer.println(answer);
    }

    public static void main(String[] args) throws IOException {
        try (B b = new B()) {
            b.solve();
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
        writer.close();
    }
}