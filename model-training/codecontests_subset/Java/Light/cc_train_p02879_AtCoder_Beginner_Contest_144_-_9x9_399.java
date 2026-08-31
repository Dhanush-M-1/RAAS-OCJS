import java.util.*;

class Main {
    final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a > 9 || b > 9 ? -1 : a*b);
    }
}

