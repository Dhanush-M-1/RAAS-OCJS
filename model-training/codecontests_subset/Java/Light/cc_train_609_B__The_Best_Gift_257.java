import java.util.Scanner;

/**
 *
 * @author thachlp
 */
public class BTheBestGift {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] arrCountGenres = arrCount(arr, n, m);

        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                result += arrCountGenres[i] * arrCountGenres[j];
            }
        }
        System.out.println(result);

    }

    static int[] arrCount(int[] arr, int n, int m) {
        int[] result = new int[m];
        for (int i = 1; i <= m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }
            result[i - 1] = count;
        }
        return result;
    }

}