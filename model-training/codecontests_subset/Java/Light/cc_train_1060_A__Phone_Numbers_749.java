import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String s = scanner.next();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < n; i++)
            if (chars[i] == '8')
                count++;
        System.out.println(Math.min(count, n / 11));
    }
}
