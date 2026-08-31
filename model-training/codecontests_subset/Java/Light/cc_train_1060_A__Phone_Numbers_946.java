import java.util.*;

public class PhoneNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String temp = sc.next();
        int length = temp.length();
        int cE = 0;
        for (int i = 0 ; i < length; i++) {
            if (temp.charAt(i)-'8' == 0) {
                cE++;
            }
        }
        if (cE < length/11) {
            System.out.println(cE);
        }
        else {
            System.out.println(length/11);
        }
        sc.close();
    }
}