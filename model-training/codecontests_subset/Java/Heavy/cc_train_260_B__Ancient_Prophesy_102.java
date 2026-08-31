import java.util.Scanner;
public class Main {
    public static void main( String[] strings ) {
        Scanner in = new Scanner( System.in );
        String str = in.next();
        int i, j;
        int[] cnt = new int[1200];
        for ( i = 0; i < 1200; ++i ) {
            cnt[i] = 0;
        }
        int base, d, m;
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int k;
        for ( k = 2013; k <= 2015; ++k ) {
            String year = String.valueOf(k);
            base = 400 * ( k - 2013 );
            for ( i = 0; i < str.length();  ) {
                j = str.indexOf(year, i);
                if ( j < 0 ) {
                    break;
                }
                i = j + 1;
                if ( j < 6 ) {
                    continue;
                }
                try {
                    d = Integer.parseInt(str.substring(j-6, j-4));
                    m = Integer.parseInt(str.substring(j-3, j-1));
                    if ( (m < 1) || (m > 12) || (d < 1) || (d > month[m-1])
                           || (str.charAt(j-4) != '-') || (str.charAt(j-1) != '-')) {
                        continue;
                    }
                }
                catch(NumberFormatException exc) {
                    continue;
                }
                ++cnt[d + (m-1)*32 + base];
            }
        }
        for ( j = 0, i = 1; i < 1200; ++i ) {
            if ( cnt[i] > cnt[j] ) {
                j = i;
            }
        }
        int r = j % 400;
        System.out.printf("%02d-%02d-%4d\r\n", r%32, r/32 + 1, j/400 + 2013);
    }
}
