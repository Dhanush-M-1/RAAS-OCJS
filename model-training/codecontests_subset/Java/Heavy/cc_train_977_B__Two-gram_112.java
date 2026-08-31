import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String str = sc.next();
        int[] arr = new int[26 * 26];
        for(int i = 0; i < len - 1; i++) {
            arr[loc(str.substring(i, i + 2))]++;
        }
        int max = arr[0];
        int idx = 0;
        for(int i = 1; i < 26 * 26; i++) {
            if(max < arr[i]) {
                max = arr[i];
                idx = i;
            }
        }
        System.out.println(res(idx));
    }

    static int loc(String str) {
        return (str.charAt(0) - 'A') * 26 + (str.charAt(1) - 'A') * 1;
    }

    static String res(int i) {
        String res = "";
        res = res + Character.toString((char) ('A' + 0 + i / 26)) + Character.toString((char) ('A' + 0 + i % 26));
        return res;
    }
}
