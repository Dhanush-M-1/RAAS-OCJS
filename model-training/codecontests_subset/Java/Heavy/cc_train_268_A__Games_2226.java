import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nTeams = scanner.nextInt();

        Map<Integer, Integer> homeJacket = new HashMap<>() ;
        Map<Integer, Integer> awayJacket = new HashMap<>() ;
        for (int i=0; i < nTeams; i++) {
            int homeJacketValue = scanner.nextInt() ;
            if (!homeJacket.containsKey(homeJacketValue)) {
                homeJacket.put(homeJacketValue, 1) ;
            } else {
                homeJacket.put(homeJacketValue, homeJacket.get(homeJacketValue) + 1);
            }

            int awayJacketValue = scanner.nextInt() ;
            if (!awayJacket.containsKey(awayJacketValue)) {
                awayJacket.put(awayJacketValue, 1) ;
            } else {
                awayJacket.put(awayJacketValue, awayJacket.get(awayJacketValue) + 1);
            }
        }

        Iterator it = homeJacket.entrySet().iterator();
        int final_count = 0 ;
        for (Map.Entry<Integer, Integer> entry : homeJacket.entrySet()) {
            if (awayJacket.containsKey(entry.getKey())) {
                final_count += awayJacket.get(entry.getKey()) * entry.getValue();
                }
        }

        System.out.println(final_count);

    }
}