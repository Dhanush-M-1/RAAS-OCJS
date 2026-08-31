import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int r = 0;
        sc.nextLine();
        String s = sc.nextLine();
//        if ( y != 0 ) {
            for (int i = 1; i <= x; i++) {
                if (i < y + 1) {
                    if (s.charAt(s.length() - i) == '1') r++;
                } else if ( i == y + 1){
                    if (s.charAt(s.length() - i) == '0') r++;
                } else {
                    if (s.charAt(s.length() - i) == '1') r++;
                }
            }
//        } else {
//            if ( s.charAt(s.length() - 1 ) == '0' ) r++;
//        }
        System.out.println(r);
    }
}