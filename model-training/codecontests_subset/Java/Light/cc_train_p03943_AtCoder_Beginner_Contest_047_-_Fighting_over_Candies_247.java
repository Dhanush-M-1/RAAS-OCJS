import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int[] a = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
        Arrays.sort(a);
        if (a[0] + a[1] == a[2]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
