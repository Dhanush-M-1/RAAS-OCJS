import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner in = new Scanner (System.in);
        int k = in.nextInt();

        String s = in.next();
        int [] frequency = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            ++frequency[(int)s.charAt(i) - 'a'];
        }

        boolean divisible = true;

        for (int i = 0; i < 26 && divisible == true; ++i) {
            if (frequency[i] % k != 0)
                divisible = false;
            else
                frequency[i] /= k;
        }

        if (divisible == false)
            System.out.println(-1);
        else {
            String answer = "";
            for (int i = 0; i < 26; ++i) {
                for (int j = 0; j < frequency[i]; ++j)
                    answer += (char)(i + 'a');
            }
            for (int i = 0; i < k; ++i)
                System.out.print(answer);
        }
    }
}
