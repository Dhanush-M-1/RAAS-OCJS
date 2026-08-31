import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<Integer> odds = new ArrayList<Integer>();
        ArrayList<Integer> evens = new ArrayList<Integer>();
        int totalSum = 0;

        for (int i = 0; i < n; i += 1) {
            int num = in.nextInt();
            totalSum += num;

            if (num % 2 == 1) {
                odds.add(num);
            } else {
                evens.add(num);
            }
        }

        Comparator<Integer> revComp = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b.compareTo(a);
            }
        };

        Collections.sort(odds, revComp);
        Collections.sort(evens, revComp);

        int commonSize = Math.min(odds.size(), evens.size());
        int res = totalSum
                - prefixSum(odds, commonSize)
                - prefixSum(evens, commonSize);

        System.out.println(res);

    }

    private static int prefixSum(final ArrayList<Integer> arr, int commonSize) {
        int sum = 0;
        for (int i = 0; i < Math.min(commonSize + 1, arr.size()); i += 1) {
            sum += arr.get(i);
        }
        return sum;
    }
}
