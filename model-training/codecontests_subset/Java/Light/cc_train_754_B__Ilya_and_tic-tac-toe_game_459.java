import java.util.Scanner;

public class Round390Div2B {
    private static String[] field;
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        field = new String[4];
        for (int i=0; i<4; i++) {
            field[i] = sc.next();
        }

        System.out.println(solve());
    }

    private static String solve() {
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if (field[i].charAt(j) == 'o') continue;

                if (check(get(i, j), get(i+1, j), get(i+2, j)) ||
                        check(get(i, j), get(i, j+1), get(i, j+2)) ||
                        check(get(i, j), get(i+1, j+1), get(i+2, j+2)) ||
                        check(get(i, j), get(i+1, j-1), get(i+2, j-2))) {
                    return "YES";
                }
            }
        }

        return "NO";
    }

    private static char get(int i, int j) {
        if (i < 0 || i >= 4 || j < 0 || j >= 4) return 'o';

        return field[i].charAt(j);
    }

    private static boolean check(char a, char b, char c) {
        if (a == 'o' || b == 'o' || c == 'o') return false;

        if (a == 'x' && b == 'x' || b == 'x' && c == 'x' || c == 'x' && a == 'x') {
            return true;
        }

        return false;
    }
}
