import java.util.*;

public class Path {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String str = in.nextLine();
        if (process(str)) System.out.println("yes");
        else System.out.println("no");
    }

    public static boolean process(String s) {
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                int count = 0;
                for (int z = j; z < s.length(); z += i)
                    if (s.charAt(z) == '*') {
                        count++;
                        if (count == 5) return true;
                    }
                    else {
                        count = 0;
                    }
            }
        }
        return false;
    }
}
