import java.util.*;

public class Main {

    public static class MyComp implements Comparator<Long> {
        public int compare(Long a, Long b) {
            return a.compareTo(b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Long> v1 = new ArrayList<>();
        List<Long> v2 = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            v1.add(sc.nextLong());
        }
        for(int i = 0; i < n; i++) {
            v2.add(sc.nextLong());
        }
        v2.sort(new MyComp());
        long maxR = Long.MAX_VALUE;
        for(int i = 0; i<n; i++) {
            boolean possible = true;
            long r  = 0;
            if(v2.get(0) >= v1.get(i)) {
                r = (v2.get(0) - v1.get(i));
            } else {
                r = (m-v1.get(i) + v2.get(0));
            }
            List<Long> result = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                result.add((v1.get(j) + r)%m);
            }
            result.sort(new MyComp());
            for( int j = 0; j < n; j++) {
                if(result.get(j).compareTo(v2.get(j)) != 0) {
                    possible = false;
                    break;
                }
            }
            if(possible) {
                if(r < maxR) {
                    maxR = r;
                }
            }
        }
        System.out.println(maxR);
    }
}
