import java.util.*;

public class Main {

    public static void print(Object x) {
        System.out.println(x + "");
    }
    public static ArrayList<String> readChars(String s) {
        ArrayList<String> out = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            out.add(s.substring(i, i+1));
        }
        return out;
    }

    public static boolean isValid(String date) {
        ArrayList<String> s = readChars(date);
        for (int i : new int[] {2, 5}) {
            if (!s.get(i).equals("-")) return false;
        }
        for (int i : new int[] {0, 1, 3, 4, 6, 7, 8, 9}) {
            if (!"0123456789".contains(s.get(i))) return false;
        }
        int dd = Integer.parseInt(date.substring(0, 2));
        int mm = Integer.parseInt(date.substring(3, 5));
        int yyyy = Integer.parseInt(date.substring(6, 10));
        if (!(yyyy >= 2013 && yyyy <= 2015)) return false;
        if (!(mm >= 1 && mm <= 12)) return  false;
        int[] monthToDays = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (!(dd >= 1 && dd <= monthToDays[mm])) return false;
        return true;
    }

    public static void solve(String prophecy) {
        Map<String, Integer> appearances = new HashMap<String, Integer>();
        for (int i = 0; i < prophecy.length() - 9; i++) {
            String date = prophecy.substring(i, i + 10);
            if (isValid(date)) {
                if (!appearances.containsKey(date)) {
                    appearances.put(date, 0);
                }
                appearances.put(date, appearances.get(date) + 1);
            }
        }

        String maxDate = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : appearances.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxDate = entry.getKey();
            }
        }
        print(maxDate);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        solve(in.next());
    }
}
