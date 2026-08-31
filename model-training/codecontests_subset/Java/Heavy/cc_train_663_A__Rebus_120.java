import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        //String originalLine="? = 1000000";
        String originalLine = buffer.readLine();

        String line = originalLine.replaceAll(" ", "");
        int plusCnt = 1;
        int minusCnt = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '+') {
                plusCnt++;
            } else if (line.charAt(i) == '-') {
                minusCnt++;
            }
        }
        int posCnt = plusCnt + minusCnt;
        int n = Integer.parseInt(line.split("=")[1]);

        int max = plusCnt*n - minusCnt;
        int min = plusCnt - minusCnt*n;

        if (n < min || n > max) {
            System.out.println("Impossible");
            return;
        }

        // init arr
        int[] plusNumbers = new int[plusCnt];
        for (int i = 0; i < plusCnt; i++) {
            plusNumbers[i] = 1;
        }
        int[] minusNumbers = new int[minusCnt];
        for (int i = 0; i < minusCnt; i++) {
            minusNumbers[i] = 1;
        }

        int sum = plusCnt - minusCnt;

        // indexes
        int i_plus = 0;
        int i_minus = 0;

        while (sum != n) {
            if (sum < n) {
                plusNumbers[i_plus] = 1 + Math.min(n - 1, n - sum);
                sum = sum + (plusNumbers[i_plus] - 1);
                i_plus++;
            } else {
                minusNumbers[i_minus] = 1 + Math.min(n - 1, sum - n);
                sum = sum - (minusNumbers[i_minus] - 1);
                i_minus++;
            }
        }

        // output
        boolean plus = true;  // first "?" is plus
        StringBuilder sb = new StringBuilder();
        i_plus = 0;
        i_minus = 0;
        for (int i = 0; i < originalLine.length(); i++) {
            char c = originalLine.charAt(i);
            if (c == '?') {
                if (plus) {
                    sb.append(plusNumbers[i_plus]);
                    i_plus++;
                } else {
                    sb.append(minusNumbers[i_minus]);
                    i_minus++;
                }
            } else if (c == '+') {
                plus = true;
                sb.append(c);
            } else if (c == '-') {
                plus = false;
                sb.append(c);
            } else {
                sb.append(c);
            }
        }

        System.out.println("Possible");
        System.out.println(sb);
    }
}
