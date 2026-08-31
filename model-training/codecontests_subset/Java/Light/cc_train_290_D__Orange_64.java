import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        int n = in.nextInt();
        str = str.toLowerCase();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            Integer k = Integer.valueOf(c);
            if (k < (n + 97)) {
                String s = "";
                s = "" + c;
                result += s.toUpperCase();
            }
            else {
                String s = "";
                s = "" + c;
                result += s.toLowerCase();
            }
        }

        System.out.println(result);
    }
}
