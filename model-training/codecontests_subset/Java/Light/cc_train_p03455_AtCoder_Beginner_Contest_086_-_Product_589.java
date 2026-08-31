import java.util.Scanner;

class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println((n * m) % 2 == 1 ? "Odd" : "Even");
    }
}