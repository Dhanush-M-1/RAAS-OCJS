import java.util.Scanner;

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = scanner.next();
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='8')
                counter++;
        }

        n/=11;
        if (counter < n && n!=0)
            System.out.println(counter);
        else
            System.out.println(n);
    }
}
