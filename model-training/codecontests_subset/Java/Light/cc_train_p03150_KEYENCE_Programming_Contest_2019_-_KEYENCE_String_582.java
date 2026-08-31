import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] t = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            t[i] = s.substring(i, i + 1);
        }

        for (int l = 0; l < s.length(); l++ ) {
            for (int r = 0 ; r < s.length(); r++) {
                StringBuilder sb = new StringBuilder();
                if (l < r) {
                    for (int i = 0 ; i <= l ; i++) {
                        sb.append(t[i]);
                    }
                    for (int i = r ; i < s.length();i++ ) {
                        sb.append(t[i]);
                    }
                }

                if (sb.toString().equals("keyence")) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }

}
