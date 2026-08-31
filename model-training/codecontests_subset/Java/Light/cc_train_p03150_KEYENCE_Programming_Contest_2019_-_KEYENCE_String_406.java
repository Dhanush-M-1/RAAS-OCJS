import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ok = "keyence";
        String s = sc.next();
        for (int i = 0; i < ok.length(); i++) {
            if(s.startsWith(ok.substring(0,i)) && s.endsWith(ok.substring(i))) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}