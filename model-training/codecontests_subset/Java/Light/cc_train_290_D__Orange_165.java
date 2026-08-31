import java.util.Locale;
import java.util.Scanner;

public class D290 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        char[] S = in.next().toLowerCase().toCharArray();
        int N = in.nextInt();
        StringBuilder output = new StringBuilder();
        for (char c : S) {
            int codePoint = c;
            if (codePoint < N + 97) {
                output.append(Character.toUpperCase(c));
            } else {
                output.append(Character.toLowerCase(c));
            }
        }
        System.out.println(output);
    }

}
