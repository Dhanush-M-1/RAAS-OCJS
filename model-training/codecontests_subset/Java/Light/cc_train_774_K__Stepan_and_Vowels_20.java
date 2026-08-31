import java.util.*;

public class Main {
    
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        int count = 0, len = 0;
        if ("eo".indexOf(s.charAt(0)) != -1) {
            len = 1;
        } else {
            System.out.print(s.charAt(0));
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                if (len == 2) {
                    System.out.print("" + s.charAt(i - 1) + s.charAt(i - 1));
                } else if (len > 0) {
                    System.out.print(s.charAt(i - 1));
                }
            }

            if ("eoaiuy".indexOf(s.charAt(i)) == -1) {
                len = 0;
                System.out.print(s.charAt(i));

            } else {
                if ("eo".indexOf(s.charAt(i)) != -1) {
                    if (s.charAt(i) == s.charAt(i - 1)) {
                        len++;
                    } else {
                        len = 1;

                    }
                } else if (s.charAt(i - 1) != s.charAt(i)) {
                    len = 0;
                    System.out.print(s.charAt(i));
                }
            }
        }
        if (len == 2) {
            System.out.print("" + s.charAt(s.length() - 1) + s.charAt(s.length() - 1));
        } else if (len > 0) {
            System.out.print(s.charAt(s.length() - 1));
        }
    }
}