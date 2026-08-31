import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        //Scanner scanner = new Scanner(new FileInputStream(new File("test")));

        int N = scanner.nextInt();
        String s = scanner.next();

        if ((N&1)==1) {
            System.out.println(1);
            System.out.println(s);
            return;
        }

        int k = 0;
        for (char c : s.toCharArray()) {
            if (c=='1') k++;
        }

        if (2*k != N) {
            System.out.println(1);
            System.out.println(s);
            return;
        }

        System.out.println(2);
        System.out.printf("%s ", s.substring(0, 1));
        System.out.println(s.substring(1));

        scanner.close();
    }
}
