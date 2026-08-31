import java.util.Scanner;

public class FriendsMeeting {
    static int compute(int n) {
        return n * (n+1) / 2;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x, y;
        x = scanner.nextInt();
        y = scanner.nextInt();
        int dist = Math.abs(x-y);
        int ans;
        if (dist % 2 == 0)
            ans = compute(dist/2)*2;
        else
            ans = compute(dist/2) + compute(dist/2+1);
        System.out.println(ans);
    }
}
