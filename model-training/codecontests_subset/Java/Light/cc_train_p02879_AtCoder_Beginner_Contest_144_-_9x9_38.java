import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int result = num1 <= 9 && num2 <= 9 ? num1 * num2 : -1;
        System.out.println(result);

    }
}