import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Integer> home = new HashMap<>();
        Map<Integer, Integer> guest = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int color = in.nextInt();
            home.putIfAbsent(color, 0);
            home.put(color, home.get(color) + 1);
            color = in.nextInt();
            guest.putIfAbsent(color, 0);
            guest.put(color, guest.get(color) + 1);
        }
        for (Integer key : home.keySet()) {

            if (guest.get(key) != null) {
                sum += home.get(key) * guest.get(key);
            }
        }
        System.out.println(sum);

    }

}
