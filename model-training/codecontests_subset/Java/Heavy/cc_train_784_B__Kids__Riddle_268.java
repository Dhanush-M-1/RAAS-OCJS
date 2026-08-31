import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        
        String hexSTR = Integer.toHexString(n);
       
        hexSTR = hexSTR.toUpperCase();
        
        char Char[] = hexSTR.toCharArray();
        
        int a = 0;

        for (int i = 0; i < Char.length; i++) {
            if (Char[i] == '4' || Char[i] == '6' || Char[i] == '9' || Char[i] == '0' || Char[i] == 'A' || Char[i] == 'D')
            {
                a++;
            }
            else if (Char[i] == '8' || Char[i] == 'B')
            {
                a += 2;
            }
        }
        System.out.println(a);
    }
}