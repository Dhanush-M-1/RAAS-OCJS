import java.util.Scanner;

public class ChatServersOutgoingTraffic {
    public static void main(String[] args) {
        int a = 0, res = 0;
        try (Scanner s = new Scanner(System.in)) {
            while (s.hasNext()) {
                String l = s.nextLine();
                if (l.charAt(0)=='+')a++;
                else if (l.charAt(0)=='-')a--;
                else res += a * (l.length() - l.indexOf(":") - 1);
            }
        }
        System.out.println(res);
    }
}