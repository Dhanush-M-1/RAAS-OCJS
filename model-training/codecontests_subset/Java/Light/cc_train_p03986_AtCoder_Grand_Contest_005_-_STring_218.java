import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        int scnt = 0;
        int tcnt = 0;
        for (int i = 0; i < x.length(); i++) {
            char c = x.charAt(i);
            if (c == 'T') {
                if (scnt <= 0) {
                    tcnt++;
                } else {
                    scnt--;
                }
            } else {
                scnt++;
            }
        }
        System.out.println(tcnt + scnt);
    }

}
