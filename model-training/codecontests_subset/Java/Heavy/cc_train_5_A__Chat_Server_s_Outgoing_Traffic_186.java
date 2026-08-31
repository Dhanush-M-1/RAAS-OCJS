import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String str;
        Set<String> set = new HashSet<>();

        int res = 0;

        while (s.hasNextLine()) {
            str = s.nextLine();

            if (str.charAt(0) == '+')
                set.add(str.substring(1));
            else if (str.charAt(0) == '-')
                set.remove(str.substring(1));
            else {
                int msgLength = str.substring(str.indexOf(':') + 1).length();
                res += msgLength * set.size();
            }
        }

        s.close();

        System.out.println(res);
    }
}