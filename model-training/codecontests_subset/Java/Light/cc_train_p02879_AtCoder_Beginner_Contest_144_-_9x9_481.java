import java.util.*;

class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.println(A < 10 && B < 10 ? A * B : -1);
    }
}
