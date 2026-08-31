import java.util.*;

public class Main {
    
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        char cur;
        int count = 0, len = 0, i = 0;
        
        while (i < s.length()) {
            cur = s.charAt(i);

            if ("eoaiuy".indexOf(cur) == -1) {
                System.out.print(cur);
                i++;
            } else {
                
                len = 0;

                while (i < s.length() && cur == s.charAt(i)) {
                    len++;
                    i++;
                }

                if ("eo".indexOf(cur) != -1 && len == 2) {
                    System.out.print("" + cur + cur);
                } else {
                    System.out.print(cur);
                }
            }
        }
    }
}