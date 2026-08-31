
import java.util.*;

public class Solution {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        s += in.nextInt();
        s += in.nextInt();
        s += in.nextInt();
        s += in.nextInt();
        if (s % 5 == 0 && s!=0) {
            System.out.println(s / 5);
        } else {
            System.out.println("-1");
        }

    }

}
