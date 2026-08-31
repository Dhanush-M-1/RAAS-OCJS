import java.util.Scanner;

public class Problem868A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        String[] kash = new String[101];
        for (int i = 0; i < n; i++) {
            kash[i] = in.next();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (kash[i].equals(s) || kash[j].equals(s)) {
                    System.out.println("YES");
                    return;
                }
                String t = kash[i] + kash[j];
                if (t.contains(s)) {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");
    }
}
