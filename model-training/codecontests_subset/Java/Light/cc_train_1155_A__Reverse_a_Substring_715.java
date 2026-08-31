import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        boolean found = false;
        for (int i = 1; i < n; i++ ) {
            if (s.charAt(i) < s.charAt(i-1) ) {
                System.out.println("YES");
                System.out.println(i + " " + (i+1));
                found = true;
                break;
            }
        }
        if ( !found) System.out.println("NO");

    }
}
