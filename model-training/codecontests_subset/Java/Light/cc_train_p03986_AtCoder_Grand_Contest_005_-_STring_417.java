import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        test();
        System.out.println(solve(sc.next().trim()));
    }

    private static int solve(String str) {
        int s = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'S') {
                s++;
            } else if (str.charAt(i) == 'T' && s == 0) {
                count++;
            } else {
                s--;
            }
        }

        return count * 2;
    }

    private static void test() {
        assert solve("TSTTSS") == 4: "TSTTSS";
        assert solve("SSTTST") == 0: "SSTTST";
        assert solve("TSSTTTSS") == 4: "TSSTTTSS";
    }
}
