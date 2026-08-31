import java.util.Scanner;

public final class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int a = 0, b = 0, c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') a++;
            else if (s.charAt(i) == '2') b++;
            else if (s.charAt(i) == '3') c++;
        }
        while (a-- > 0) {
            System.out.print("1");
            if (a > 0 || b > 0 || c > 0) System.out.print("+");
        }
        while (b-- > 0) {
            System.out.print("2");
            if (b > 0 || c > 0) System.out.print("+");
        }
        while (c-- > 0) {
            System.out.print("3");
            if (c > 0) System.out.print("+");
        }
    }
}