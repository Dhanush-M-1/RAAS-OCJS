
import java.util.Scanner;

public class Orange {

    static Scanner in;
    static String S, New = "";
    static int N;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        S = in.next().toLowerCase();
        N = in.nextInt();
        int aux;
        for (int i = 0; i < S.length(); i++) {
            aux = (int) S.charAt(i);
            if (aux < N + 97) {
                New += Character.toString(S.charAt(i)).toUpperCase();
            } else {
                New += Character.toString(S.charAt(i)).toLowerCase();
            }
        }
        System.out.println(New);
    }
}
