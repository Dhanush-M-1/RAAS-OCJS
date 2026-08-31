import java.util.*;

public class BarkToUnlock {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        char [] password = in.next().toCharArray();
        int n = in.nextInt();
        char [] word;
        boolean firstMatch = false;
        boolean secondMatch = false;

        for (int i = 0; i < n; i++) {
            word = in.next().toCharArray();

            if (Arrays.equals(word, password)) {
                System.out.println("YES");
                return;
            }

            if (password[0] == word[1]) firstMatch = true;
            if (password[1] == word[0]) secondMatch = true;
        }   

        if (firstMatch == true && secondMatch == true)  System.out.println("YES");
        else System.out.println("NO");
        
        in.close();
    }
}