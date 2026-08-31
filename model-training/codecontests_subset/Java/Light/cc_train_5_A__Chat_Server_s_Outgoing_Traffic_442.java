import java.util.*;

public class ChatServerOutgoingTraffic {
    public static void main(String a[]) {
        Scanner cin = new Scanner(System.in);
        String s = "\0";
        int n = 0, m = 0;
        while (cin.hasNextLine()) {
            s = cin.nextLine();
            if (s.charAt(0) == '+')
                n++;
            else {
                if (s.charAt(0) == '-')
                    n--;
                else
                    m += ((s.length() - s.indexOf(':') - 1) * n);
            }
        }
        cin.close();
        System.out.print(m);
    }
}