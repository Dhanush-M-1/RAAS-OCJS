import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class B1144 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] A = new int[N];
        for (int n=0; n<N; n++) {
            A[n] = in.nextInt();
        }
        int answer = Math.min(answer(A, true), answer(A, false));
        System.out.println(answer);
    }

    private static int answer(int[] A, boolean odd) {
        List<Integer> oddList = new ArrayList<Integer>();
        List<Integer> evenList = new ArrayList<Integer>();
        for (int a : A) {
            if (a%2 == 0) {
                evenList.add(a);
            } else {
                oddList.add(a);
            }
        }
        Collections.sort(oddList);
        Collections.sort(evenList);
        Collections.reverse(oddList);
        Collections.reverse(evenList);
        while (true) {
            if (odd) {
                if (oddList.isEmpty()) break;
                oddList.remove(0);
            } else {
                if (evenList.isEmpty()) break;
                evenList.remove(0);
            }
            odd = !odd;
        }
        int sum = 0;
        for (int x : oddList) sum += x;
        for (int x : evenList) sum += x;
        return sum;
    }

}
