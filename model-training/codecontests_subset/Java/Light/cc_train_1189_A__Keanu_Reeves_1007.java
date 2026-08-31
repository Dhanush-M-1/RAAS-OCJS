
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Div2Ques1 {
    public static void main(String... args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int n = s.nextInt();
        String str = s.next();;
        int zeros  = 0;
        int ones  = 0;
        for(int i = 0;i<str.length();i++) {
            if(str.charAt(i) == '0') {
                zeros+=1;
            } else {
                ones+=1;
            }
        }
        StringBuilder ans = new StringBuilder();
        ans.append(str.charAt(0));
        if (zeros == ones) {
            System.out.println("2");
            ans.append(' ');
        } else {
            System.out.println("1");
        }
        for (int i= 1;i<str.length();i++) {
            ans.append(str.charAt(i));
        }
        System.out.println(ans.toString());
    }
}
