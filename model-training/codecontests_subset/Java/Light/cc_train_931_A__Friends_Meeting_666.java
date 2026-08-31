import java.util.*;

public class FriendsMeeting {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int i = scn.nextInt();
        int f = scn.nextInt();

        int val = (Math.abs(i + f)) / 2;
        int min = Math.min(i, f);
        int max = Math.max(i, f);
        int ans = 0;
        while (val - min > 0) {
            ans += (val - min);
            min++;
        }
        while (max - val > 0) {
            ans += (max - val);
            max--;
        }
        System.out.println(ans);

    }
}