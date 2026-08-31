import java.util.*;

public class FriendsMeeting {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int i = scn.nextInt();
        int f = scn.nextInt();

        int val = Math.abs(i - f);
        int first = val / 2;
        int sec = val - first;

        int ans1 = (first * (first + 1)) / 2;
        int ans2 = (sec * (sec + 1)) / 2;
        System.out.println(ans1 + ans2);

    }
}