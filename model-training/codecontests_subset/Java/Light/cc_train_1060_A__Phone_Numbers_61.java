import java.util.Scanner;

/**
 * Created by PQZR3864 on 2018-10-04.
 */
public class PhoneNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        int n = input.nextInt();
        String digits = input.next();

        for(int i=0 ; i<digits.length() ;i++){
            if(digits.charAt(i) == '8') count++;
        }
        count = count > (n/11) ? (n/11) : count ;
        System.out.println(count);
        input.close();
    }
}
