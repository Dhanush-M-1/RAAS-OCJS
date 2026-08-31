import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int left = scanner.nextInt();
        int right = scanner.nextInt();

        if(left == right) {
            System.out.println(left);
        } else {
            System.out.println(2);
        }
    }
}
