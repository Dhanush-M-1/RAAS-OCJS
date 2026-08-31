import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] arr = s.toCharArray();
        int max = -1;
        String r = "";
        for ( int i = 1; i < n; i++ ) {
            int c = 0;
            char a = arr[i - 1];
            char b = arr[i];

            for  (int j = 1;  j < n; j++ ) {
                if ( a == arr[j-1] && b == arr[j] ) {
                    c++;
                }
            }
            if ( c > max) {
                max = c;
                r = "" + a + b;
            }
        }
        System.out.println(r);

    }
}
