import java.util.*;

public class LetsWatchFootball {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int b = cin.nextInt();
        int c = cin.nextInt();
        int x = (a * c - 1) / b + 1;
        System.out.println(x - c);
    }
}