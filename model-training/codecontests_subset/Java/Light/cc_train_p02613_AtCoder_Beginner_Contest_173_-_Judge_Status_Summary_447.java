import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ac = 0;
        int wa = 0;
        int tle = 0;
        int re = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.equals("AC")) ac++;
            else if (s.equals("WA")) wa++;
            else if (s.equals("TLE")) tle++;
            else if (s.equals("RE")) re++;
        }
        System.out.println(String.format("AC x %d\nWA x %d\nTLE x %d\nRE x %d", ac, wa, tle, re));
    }
}