
import java.util.Scanner;

public class Solution {
    
    public static void main(String args[]) {
        Scanner Input = new Scanner(System.in);
        int N = Input.nextInt();
        String S = Input.next();
        int Zero = S.length() - S.replaceAll("0", "").length();
        int One = S.length() - S.replaceAll("1", "").length();
        if (Zero != One) {
            System.out.println("1");
            System.out.println(S);
        } else {
            System.out.println("2");
            System.out.println(S.substring(0, 1) + " " + S.substring(1));
        }
    }
    
}
