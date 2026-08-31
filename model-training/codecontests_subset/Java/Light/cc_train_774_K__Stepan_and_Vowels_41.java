import java.util.Scanner;

public class Main {

    private static boolean contains(char[] chars, char c) {
        for (char ch : chars)
            if (ch == c)
                return true;
        return false;
    }

    public static void main(String[] args) {

        char[] vowels = new char[] {
                'a', 'e', 'i', 'o', 'u', 'y'
        };

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String word = scanner.next();

        StringBuilder stringBuilder = new StringBuilder();

        int repetition = 0;
        char symbol = 0;
        boolean forcePrint = false;
        for (int i = 0; i < n; i++) {

            if ((symbol != word.charAt(i) || forcePrint) && repetition > 0) {

                stringBuilder.append(symbol);

                if (repetition == 2 && (symbol == 'e' || symbol == 'o'))
                    stringBuilder.append(symbol);

                repetition = 0;
            }

            ++repetition;
            symbol = word.charAt(i);

            forcePrint = false;

            if (!contains(vowels, symbol)) {
                repetition = 1;
                forcePrint = true;
            }
        }

        stringBuilder.append(symbol);

        if (repetition == 2 && (symbol == 'e' || symbol == 'o'))
            stringBuilder.append(symbol);

        System.out.println(stringBuilder.toString());
    }
}
