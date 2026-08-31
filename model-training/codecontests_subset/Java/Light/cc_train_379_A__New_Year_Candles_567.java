import java.util.*;

public class Main {

    public static void easy() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println((a * b - 1) / (b - 1));
    }

    public static void main(String[] args) throws Exception {
        easy();
    }
}