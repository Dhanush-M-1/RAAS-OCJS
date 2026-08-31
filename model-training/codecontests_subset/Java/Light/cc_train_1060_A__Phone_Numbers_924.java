import java.util.*;
import java.io.*;

public class Codeforce {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String dig = input.next();
        int num8 = 0;
        for (int i = 0; i < n; i++) {
            char c = dig.charAt(i);
            if (c == '8'){
                num8++;
            }
        }

        int ans = 0;
        while(n >= 11 && num8 > 0){
            num8--;
            n -= 11;
            ans++;
        }
        System.out.println(ans);
    }
}
