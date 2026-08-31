import java.util.*;

public class codeforces {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int tc = scan.nextInt();
        while (tc-- != 0) {
            int n = scan.nextInt();
            int m = scan.nextInt();

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            List<Integer> arrc = new LinkedList<>();

            for (int i = 0; i < n; i++)
                arr1[i] = scan.nextInt();

            for (int i = 0; i < m; i++)
                arr2[i] = scan.nextInt();

            for (int value = 0; value <= 1000; value++) {
                for (int indexn = 0; indexn < n; indexn++)
                    if (arr1[indexn] == value)
                        for (int indexm = 0; indexm < m; indexm++)
                            if (arr2[indexm] == value)
                                if (arrc.size() < 1)
                                    arrc.add(value);
                                else break;
            }

            if (arrc.size() <= 0)
                System.out.println("NO");
            else {
                System.out.println("YES");
                System.out.print(arrc.size() + " ");
                for (int item : arrc) {
                    System.out.print(item + " ");
                }
                System.out.println();
            }
        }
    }
}