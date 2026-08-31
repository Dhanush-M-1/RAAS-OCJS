import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                boolean flag = false;
                for (int start = i, end = j; start < end; start++, end--) {
                    if (s.charAt(start) > s.charAt(end)) {
                        flag = true;
                    } else if (s.charAt(start) < s.charAt(end)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    System.out.println("YES");
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                } else {
                    break;
                }

            }
        }
        System.out.println("NO");
    }

}
