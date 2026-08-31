import java.util.Scanner;

public class KString {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sum = 0;
        String change = "";
        int n = scan.nextInt();
        String str = scan.next();
        int[] array = new int[26];
        for (int i = 0; i < str.length(); i++) {
            array[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] % n != 0) {
                sum = 1;
                break;
            }
        }
        if (sum == 1) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < array[i] / n; j++) {
                    change += ((char) (i + 'a'));
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(change);
            }
            System.out.println();
        }
    }

}