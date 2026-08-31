import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int K = scanner.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }
        Collections.sort(a);
        int count = 0;
        int r = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a.get(i + 1).equals(a.get(i))) {
                r++;
                continue;
            }
            if (a.get(i + 1) > a.get(i) && a.get(i + 1) <= a.get(i) + K) {
                count++;
                count += r;
                r = 0;
            } else {
                r = 0;
            }
        }
        System.out.println(n - count);
    }
}