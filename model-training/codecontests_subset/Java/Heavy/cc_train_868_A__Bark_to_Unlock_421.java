import java.util.ArrayList;
import java.util.Scanner;

public class cf_abarktounlock { 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String pw = scan.nextLine();
        int n = scan.nextInt();
        scan.nextLine(); // eat the newline
        ArrayList<Character> zero = new ArrayList<Character>();
        ArrayList<Character> one = new ArrayList<Character>();
        ArrayList<String> all = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            String temp = scan.nextLine();
            zero.add(temp.charAt(0));
            one.add(temp.charAt(1));
            all.add(temp);
        }
        if (all.contains(pw)) {
            System.out.println("YES");
        } else if (one.contains(pw.charAt(0)) && zero.contains(pw.charAt(1))) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}