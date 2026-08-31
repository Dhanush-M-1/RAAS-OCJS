import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Mafia {

    private static int getMinRound(Integer[] desiredRound) {
        Arrays.sort(desiredRound, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int maxRound = desiredRound[0];
        double sumRound = 0;
        for(int i = 0; i < desiredRound.length; i++) {
            sumRound += desiredRound[i];
        }

        double k = Math.ceil(sumRound / (desiredRound.length - 1));

        if(k < maxRound) {
            return maxRound;
        } else {
            return (int)k;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] desiredRound = new Integer[n];

        for(int i = 0; i < n; i++) {
            desiredRound[i] = scanner.nextInt();
        }

        int result = getMinRound(desiredRound);
        System.out.println(result);

    }
}
