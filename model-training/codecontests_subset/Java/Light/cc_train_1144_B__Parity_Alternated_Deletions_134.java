
import java.util.*;

public class B {

    static int MAX_N = 2000;
    static int oddCount = 0, evenCount = 0, sum = 0;
    static Integer[] odd = new Integer[MAX_N], even = new Integer[MAX_N];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        while (N-- > 0) {
            int num = in.nextInt();
            if (num%2 == 0) even[evenCount++] = num;
            else odd[oddCount++] = num;

            sum += num;
        }

        Arrays.sort(odd, 0, oddCount, Collections.reverseOrder());
        Arrays.sort(even, 0, evenCount, Collections.reverseOrder());

        int ans = Math.min(getRemainingAfterRemove(true), getRemainingAfterRemove(false));
        System.out.println(ans);
    }

    static int getRemainingAfterRemove(boolean startWithOdd) {
        boolean nextParityOdd = startWithOdd;
        int oddPos = 0, evenPos = 0, sumRemoved = 0;
        while ((nextParityOdd && oddPos < oddCount) || (!nextParityOdd && evenPos < evenCount)) {
            if (nextParityOdd) sumRemoved += odd[oddPos++];
            else sumRemoved += even[evenPos++];
            nextParityOdd = !nextParityOdd;
        }

        return sum - sumRemoved;
    }
}
