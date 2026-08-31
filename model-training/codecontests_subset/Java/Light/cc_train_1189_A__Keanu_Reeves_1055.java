import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        int zero = 0, one = 0;
        String str = in.next();
        for (int i = 0; i < n; i++){
            if (str.charAt(i) == '0') zero++;
            else one++;
        }
        if (one != zero) {
            System.out.println(1);
            System.out.println(str);
        }
        else {
            System.out.println(2);
            System.out.println(str.substring(0, str.length()-1) + " " + str.charAt(str.length()-1));
        }
    }
}
