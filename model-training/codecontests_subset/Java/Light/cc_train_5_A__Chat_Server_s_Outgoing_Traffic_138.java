import java.util.Scanner;

public class ChatServersOutgoingTraffic {

    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        String trafico;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            trafico = sc.nextLine();

            if (trafico.charAt(0) == '+') {
                b++;
            } else if (trafico.charAt(0) == '-') {
                b--;
            } else {
                a += b * (trafico.length() - trafico.indexOf(':') - 1);
            }
        }

        System.out.println(a);
    }
}