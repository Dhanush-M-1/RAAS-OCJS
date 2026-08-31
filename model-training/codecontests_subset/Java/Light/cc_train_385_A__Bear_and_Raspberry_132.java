import java.util.*;
public class BearAndRaspberry {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int days = s.nextInt();
        int loss = s.nextInt();
        int max = 0;
        int yesterday = s.nextInt();
        for(int a = 1; a < days; a++){
            int today = s.nextInt();
            max = Math.max(max, yesterday - today - loss);
            yesterday = today;
        }
        System.out.println(max);
    }
}
