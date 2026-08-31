import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        StringBuilder sb = new StringBuilder();
        int sc = 0;
        int tc = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'S') {
                sc++;
            } else {
                if (sc == 0) {
                    sb.append('T');
                } else {
                    sc--;
                }

            }
        }
        for (int i = 0; i < sc; i++) {
            sb.append('S');
        }
        System.out.println(sb.length());
    }
}