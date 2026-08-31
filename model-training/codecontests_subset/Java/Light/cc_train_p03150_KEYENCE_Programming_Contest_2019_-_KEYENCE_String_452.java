import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s.matches(".*keyence$")) {
            System.out.println("YES");
        } else if (s.matches("^k.*eyence$")) {
            System.out.println("YES");
        } else if (s.matches("^ke.*yence$")) {
            System.out.println("YES");
        } else if (s.matches("^key.*ence$")) {
            System.out.println("YES");
        } else if (s.matches("^keye.*nce$")) {
            System.out.println("YES");
        } else if (s.matches("^keyen.*ce$")) {
            System.out.println("YES");
        } else if (s.matches("^keyenc.*e$")) {
            System.out.println("YES");
        } else if (s.matches("^keyence.*$")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}