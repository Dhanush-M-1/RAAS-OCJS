import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(ex3);

        System.out.println(solve(scanner) ? "YES" : "NO");
    }

    private static boolean solve(Scanner scanner) {
        String answer = scanner.nextLine();

        int n = Integer.parseInt(scanner.nextLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i ++) {
            words[i] = scanner.nextLine();
            if (words[i].equals(answer)) return true;
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                char[] combChars = {words[i].charAt(1), words[j].charAt(0)};
                String combStr = new String(combChars);
                if (combStr.equals(answer)) return true;
            }
        }

        return false;
    }

    private static final String ex1 = "ya\n" +
            "4\n" +
            "ah\n" +
            "oy\n" +
            "to\n" +
            "ha";
    private static final String ex2 = "hp\n" +
            "2\n" +
            "ht\n" +
            "tp";
    private static final String ex3 = "ah\n" +
            "1\n" +
            "ha";
}
