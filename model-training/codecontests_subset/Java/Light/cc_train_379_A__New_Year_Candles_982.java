import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int count = 0;
        int ostatok = 0;
        int n = 0;
        while(a > 0){
            count+=a;
            n = a + ostatok;
            a = n / b;
            ostatok = n % b;

        }
        System.out.println(count);

    }
}
