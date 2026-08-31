import java.util.*;

public class B260 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        HashMap<String, Integer> dates = new HashMap<String, Integer>();
        for (int i = 0; i <= s.length() - 10; i++) {
            char sub[] = s.substring(i, i + 10).toCharArray();
            boolean dd = Character.isDigit(sub[0]) && Character.isDigit(sub[1]);
            boolean dash1 = (sub[2] == '-');
            boolean mm = Character.isDigit(sub[3]) && Character.isDigit(sub[4]);
            boolean dash2 = (sub[5] == '-');
            boolean yyyy = Character.isDigit(sub[6])
                    && Character.isDigit(sub[7]) && Character.isDigit(sub[8])
                    && Character.isDigit(sub[9]);
            if (dd && dash1 && mm && dash2 && yyyy) {
                int ddVal = (sub[0] - '0') * 10 + (sub[1] - '0');
                int mmVal = (sub[3] - '0') * 10 + (sub[4] - '0');
                int yyyyVal = (sub[6] - '0') * 1000 + (sub[7] - '0') * 100
                        + (sub[8] - '0') * 10 + (sub[9] - '0');
                boolean ddCheck = ddVal > 0 && ddVal <= 31;
                boolean mmCheck = mmVal >= 1 && mmVal <= 12;
                boolean yyyyCheck = yyyyVal >= 2013 && yyyyVal <= 2015;
                if (ddCheck && mmCheck && yyyyCheck) {
                    int maxDays = 0;
                    switch (mmVal) {
                    case 1:
                        maxDays = 31;
                        break;
                    case 2:
                        maxDays = 28;
                        break;
                    case 3:
                        maxDays = 31;
                        break;
                    case 4:
                        maxDays = 30;
                        break;
                    case 5:
                        maxDays = 31;
                        break;
                    case 6:
                        maxDays = 30;
                        break;
                    case 7:
                        maxDays = 31;
                        break;
                    case 8:
                        maxDays = 31;
                        break;
                    case 9:
                        maxDays = 30;
                        break;
                    case 10:
                        maxDays = 31;
                        break;
                    case 11:
                        maxDays = 30;
                        break;
                    case 12:
                        maxDays = 31;
                        break;
                    }
                    if (ddVal <= maxDays) {
                        String dt = new String(sub);
                        if (dates.containsKey(dt))
                            dates.put(dt, dates.get(dt) + 1);
                        else
                            dates.put(dt, 1);
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        String ans = "";
        for (String d : dates.keySet()) {
            if (dates.get(d) > max) {
                max = dates.get(d);
                ans = d;
            }
        }
        System.out.println(ans);
    }
}
