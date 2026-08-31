
import java.util.*;

public class Solution {

    @SuppressWarnings("unused")
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String s = in.next();
        char[] schar = s.toCharArray();

        String total = "";

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String curr = in.next();
            total += curr;

        }

        //System.out.println(total);

        char[] totalChars = total.toCharArray();
        for (int i = 0; i < totalChars.length; i++) {
            if (totalChars[i] == schar[0]) {
                //System.out.println(i);
                if (i % 2 == 0) {
                    if (totalChars[i + 1] == schar[1]) {
                        System.out.println("YES");
                        return;
                    }
                } else {
                    int j = i + 1;
                    while (j < totalChars.length + i) {
                        if (totalChars[j % totalChars.length] == schar[1]) {
                            System.out.println("YES");
                            return;
                        }
                        j += 2;

                    }
                }
            }

        }

        System.out.println("NO");


    }

}
