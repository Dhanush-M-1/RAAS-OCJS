import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, Map<String, String>> map = new TreeMap<String, Map<String, String>>();
        int t = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        boolean success = false;
        int number = 1;
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            String operation = scanner.next();
            if (operation.equals("alloc")) {
                int n = scanner.nextInt();
                int k = 0;
                int start = -1;
                for (int j = 0; j < m; j++) {
                    if (a[j] == 0) {
                        k++;
                    } else {
                        k = 0;
                    }
                    if (k == n) {
                        start = j - n + 1;
                        break;
                    }

                }
                if (start == -1) {
                    System.out.println("NULL");
                } else {
                    for (int j = start; j < start + n; j++) {
                        a[j] = number;
                    }
                    System.out.println(number);
                    number++;
                }
            }
            if (operation.equals("erase")) {
                success = false;
                int block = scanner.nextInt();
                for (int j = 0; j < m; j++) {
                    if (a[j] == block) {
                        success = true;
                        a[j] = 0;
                    }
                }
                if (!success || block < 1 || block >= number) {
                    System.out.println("ILLEGAL_ERASE_ARGUMENT");
                }

            }
            if (operation.equals("defragment")) {
                int[] newA = new int[m];
                int k = 0;
                for (int j = 0; j < m; j++) {
                    if (a[j] > 0) {
                        newA[k++] = a[j];
                    }
                }
                System.arraycopy(newA, 0, a, 0, m);
            }
        }
    }
}