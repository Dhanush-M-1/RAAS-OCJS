import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new TreeSet<String>();
        int traffic = 0;
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (s.charAt(0) == '+') {
                set.add(s.substring(1));
            } else if (s.charAt(0) == '-') {
                set.remove(s.substring(1));
            } else {
                traffic += s.substring(s.indexOf(':') + 1).length() * set.size();
            }
        }
        System.out.println(traffic);

    }

}