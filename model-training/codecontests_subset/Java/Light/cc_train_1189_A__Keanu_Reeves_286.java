import java.util.Scanner;

public class Keanu_Reeves {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String s = scan.nextLine();
        int ones = 0, zeros = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1')
                ones++;
            else
                zeros++;
        }
        if (ones != zeros) {
            System.out.println("1\n" + s);
        } else {

            System.out.print(2 + "\n" + s.charAt(0) + " ");
            for (int i = 1; i < n; i++)
                System.out.print(s.charAt(i));
        }
        scan.close();
    }
}
