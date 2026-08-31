import java.util.Scanner;

public class Main {

    private static final String KEYENCE = "keyence";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        if (str.contains(KEYENCE)) {
            System.out.println("YES");
            return;
        }
        // 分割して存在している場合、文字列の最初と最後でマッチしている必要がある
        for (int i = 1; i < KEYENCE.length(); i++) {
            String s1 = KEYENCE.substring(0, i);
            String s2 = KEYENCE.substring(i);
            if (str.startsWith(s1) && str.endsWith(s2)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

}
