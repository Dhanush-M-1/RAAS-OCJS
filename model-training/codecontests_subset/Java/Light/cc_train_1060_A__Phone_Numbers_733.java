import java.util.Scanner;

public class Main1060A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String str = in.next();
            System.out.println(fn(n, str));
        }
        in.close();
    }

    public static int fn(int length, String str) {
        int res = length / 11;
        int count = 0;
        char[] ch = str.toCharArray();
        for (char c : ch) {
            if (c == '8') {
                count++;
            }
        }
        return Math.min(res, count);
    }

}
