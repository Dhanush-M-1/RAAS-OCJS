import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CodeForces977B {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int n = s.nextInt();
            String str =  "";
            String ip = s.next();
            str += ip.charAt(0);
            HashMap<String, AtomicInteger> map = new HashMap();
            for (int i = 1; i < n; i++) {
                str += ip.charAt(i);
                if (map.containsKey(str)) {
                    map.get(str).getAndIncrement();
                } else {
                    map.put(str, new AtomicInteger(1));
                }
                str = ""+ip.charAt(i);
            }
            System.out.println(Collections.max(map.entrySet(),
                    Comparator.comparingInt(entry -> entry.getValue().get())).getKey());

        }
    }
}
