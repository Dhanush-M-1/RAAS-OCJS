import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        int[] charArray = new int[26];
        StringBuilder s = new StringBuilder(scan.next());
        if (s.length() % k != 0) {
            System.out.println("-1");
        } else {
            returnKString(s,k,charArray);
        }
    }

    private static void returnKString(StringBuilder s,int k, int[] charArray) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            charArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charArray[i] % k != 0) {
                System.out.println("-1");
                return;
            } else {
                charArray[i] /= k;
            }
        }
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray[i]; j++) {
                result.append((char)('a'+i));
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(result);
        }
        
    }
}
