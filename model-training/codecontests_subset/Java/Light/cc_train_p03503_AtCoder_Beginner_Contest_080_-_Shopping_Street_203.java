import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] l = new String[n];
        int[][] m = new int[n][11];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 10; j++) {
                sb.append(sc.next());
            }
            l[i] = sb.toString();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 11; j++) {
                m[i][j] = sc.nextInt();
            }
        }

        long profit = Long.MIN_VALUE;

        for (int i = 1; i < 1024; i++) {
            long tmp = 0;
            String s = fillZero(Integer.toBinaryString(i));
            for (int j = 0; j < n; j++) {
                int count = 0;
                String z = Integer.toBinaryString(Integer.parseInt(l[j], 2) & i);
                for (int k = 0; k < z.length(); k++) {
                    if (z.charAt(k) == '1') {
                        count++;
                    }
                }
                tmp += m[j][count];
            }
            profit = Math.max(profit, tmp);
        }
        System.out.println(profit);
    }

    static String fillZero(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 10) {
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
