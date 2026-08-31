import java.util.Arrays;
import java.util.Scanner;

public class BookGifted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] bookArray = new int[m];
        for (int i = 0; i < n; i++) {
            bookArray[sc.nextInt()-1] ++;
        }
        int totalBook = 0;
        for (int i = 0; i < m; i++) {
            for (int k = i+1; k < m; k++) {
                totalBook += (bookArray[i] * bookArray[k]);
            }
        }
        System.out.println(totalBook);
        sc.close();
    }
}