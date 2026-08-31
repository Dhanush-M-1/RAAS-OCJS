import java.util.*;

public class Codeforces {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        scanner.nextLine();
        String line = scanner.nextLine();

        Set<String> set = new HashSet<>();
        String res = "";
        int max = 0;

        for (int i = 0; i < line.length() - 1; i++) {
            String sub = line.substring(i, i + 2);
            if (!set.add(sub)) continue;
            int tmp = count(line, sub);
            if (tmp > max) {
                max = tmp;
                res = sub;
            }
        }

        System.out.println(res);
    }

    private static int count(String line, String sub) {
        if (sub.charAt(0) != sub.charAt(1))
            return (line.length() - line.replace(sub, "").length()) / 2;
        int res = 0;
        while (line.contains(sub)) {
            int index = line.indexOf(sub);
            line = line.substring(0, index) + line.substring(index + 1);
            res++;
        }
        return res;
    }

}
