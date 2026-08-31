
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class JavaApplication1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        //String s = in.next();
        int[] abc = new int[26];
        String s = in.next();
        //char[] c = in.next().toCharArray();
        //Arrays.sort(c);
        int groupLength = s.length() / num;

        for (int i = 0; i < s.length(); i++) {
            abc[s.charAt(i) - 'a']++;
        }
        String x = "";
        boolean Exit = false;
        for (int i = 0; i < abc.length; i++) {

            if (abc[i] > 0) {
                if (abc[i] % num != 0) {

                    Exit = true;
                    System.out.println(-1);
                    break;

                } else {

                    for (int j = 0; j < abc[i] / num; j++) {
                        x += (char) ('a' + i);
                    }
                }
            }

        }

        if (!Exit && x.length() == groupLength) {
            for (int i = 0; i < num; i++) {
                System.out.print(x);
            }
            
            System.out.println();
        }
        
    }

}
