import java.util.Scanner;
import java.util.StringTokenizer;

public class C {

    public static void main(String[] args) {
        int len[] = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        Scanner myScanner = new Scanner(System.in);
        String input = myScanner.next().replaceAll("--", "[*]")
                .replaceAll("[-]", " ");
        StringTokenizer tok = new StringTokenizer(input);

        String all[] = new String[tok.countTokens()];
        for (int i = 0; i < all.length; i++)
            all[i] = tok.nextToken();

        int dates[] = new int[31 * 12 * 2015];
        int max = -1, md = 0, mm = 0, my = 0;

        for (int i = 0; i < all.length - 2; i++) {
            try {
                if (all[i + 1].length() > 2 || all[i + 2].length() < 4)
                    continue;

                int n1 = all[i].length(), n2 = all[i + 1].length();

                int days[] = new int[2], months[] = new int[2];

                if (n1 >= 2)
                    days[1] = new Integer(all[i].substring(n1 - 2));
                else
                    days[0] = new Integer(all[i].substring(n1 - 1));

                if (n2 == 2)
                    months[1] = new Integer(all[i + 1].substring(n2 - 2));
                else
                    months[0] = new Integer(all[i + 1].substring(n2 - 1));

                int year = new Integer(all[i + 2].substring(0, 4));

                for (int j = 0; j < months.length; j++) {
                    for (int j2 = 0; j2 < days.length; j2++) {
                        int day = days[j2];
                        int mon = months[j];
                        if (day >= 1 && mon >= 1 && mon <= 12 && year >= 2013
                                && year <= 2015 && day <= len[mon]) {
                            int ii;
                            dates[(ii = day * mon * year)]++;
                            if (dates[ii] > max) {
                                max = dates[ii];
                                md = day;
                                mm = mon;
                                my = year;
                            }
                        }

                    }
                }
            } catch (Exception e) {
                continue;
            }
        }

        String sd = md + "";
        String sm = mm + "";

        if (sd.length() == 1)
            sd = '0' + sd;
        if (sm.length() == 1)
            sm = '0' + sm;

        System.out.println(sd + "-" + sm + "-" + my);
    }
}
