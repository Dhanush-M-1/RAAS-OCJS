
import java.util.Scanner;

/**
 * Main.java (UTF-8)
 *
 * 01/04/2013
 * @author arnold
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word;
        int n;
        
        word = in.next();
        n = in.nextInt();
        word = word.toLowerCase();
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            int j = (int)word.charAt(i);
            if (j < n+97) {
                answer += (char)(j-32);
            } else {
                answer += (char)j;
            }
        }
        System.out.println(answer);
    }
}
