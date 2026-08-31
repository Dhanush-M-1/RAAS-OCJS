import java.util.Scanner;

public class A168 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();

        int min = (n * y + 99) / 100;
        System.out.println(Math.max(min - x, 0));

    }

}
