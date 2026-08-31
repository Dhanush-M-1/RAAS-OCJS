

import java.util.*;

/**
 * Created by shnovruzov on 21/02/2018.
 */
public class Run {

    public static void main(String args[]) throws Exception {

        int n;
        String s;
        int count, max = 0;
        String result = null;

        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        in.nextLine();
        s = in.nextLine();

        for (int i = 0; i < s.length() - 1; i++) {
            String sub = s.substring(i, i + 2);
            count = 0;

            for (int j = 0; j < s.length() - 1; j++)
                if (sub.charAt(0) == s.charAt(j) && sub.charAt(1) == s.charAt(j + 1)) {
                    count++;
                }

            if (count > max) {
                result = sub;
                max = count;
            }

        }

        System.out.println(result);


    }
}
