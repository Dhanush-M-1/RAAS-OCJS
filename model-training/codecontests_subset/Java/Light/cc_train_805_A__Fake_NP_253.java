import java.util.Scanner;

public class FakeNP {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        long l = input.nextLong();
        long r = input.nextLong();

        if (l == r) {
            System.out.println(l);
        }
        else {
            System.out.println(2);
        }

        input.close();
    }
}
