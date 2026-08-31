import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        String modStr = in.next().substring((n - x));
        int index = ((x - y) - 1);
        int changes = ((modStr.charAt(index) == '1') ? -1 : 1);
        for (int i = 0; i < modStr.length(); i++) {
            if (modStr.charAt(i) == '1') {
                changes++;
            }
        }
        System.out.println(changes);
    }
}