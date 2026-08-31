import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] a = new int[] {1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2, 2, 5, 4, 1, 4, 1, 51};

        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        System.out.println(a[K-1]);
    }
}
