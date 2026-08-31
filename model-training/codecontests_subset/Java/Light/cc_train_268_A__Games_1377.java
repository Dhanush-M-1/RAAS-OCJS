import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FootballMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Map<Integer,Integer> hosts = new HashMap<>();
        Map<Integer,Integer> guests = new HashMap<>();
        for(int i=0;i<n;i++) {
            int h = scanner.nextInt();
            int g = scanner.nextInt();

            hosts.computeIfPresent(h, (x,y)->y=y+1);
            hosts.computeIfAbsent(h, y->1);

            guests.computeIfPresent(g, (x,y)->y=y+1);
            guests.computeIfAbsent(g, y->1);

        }

        int count=0;
        for(Map.Entry<Integer, Integer> entry : hosts.entrySet()) {
            if(guests.containsKey(entry.getKey())) {
                count+=entry.getValue()* guests.get(entry.getKey());
            }

        }
        System.out.println(count);



    }
}