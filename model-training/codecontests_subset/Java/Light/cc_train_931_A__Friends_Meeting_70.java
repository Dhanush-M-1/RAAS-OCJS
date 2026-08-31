
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Integer.parseInt;

public class FriendsMeeting {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = parseInt(reader.readLine());
        int b = parseInt(reader.readLine());
        int diff = Math.abs(a - b);
        int f = (int) Math.ceil(diff / 2.0);
        int s = diff / 2;
        System.out.println((f * (f + 1) / 2 + s * (s + 1) / 2));

    }

}
