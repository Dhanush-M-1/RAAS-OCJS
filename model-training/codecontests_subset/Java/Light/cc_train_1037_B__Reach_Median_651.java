/**
 * Created by nikhil on 2/9/18.
 */
import java.util.*;
public class B1037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);

        int currentNumber = a[n / 2];
        int currentIndex = n / 2;
        long count = 0;
        if(currentNumber == s) {
            System.out.println(0);
            return;
        } else if(currentNumber > s) {
            while(currentNumber > s && currentIndex >= 0) {

                count += Math.abs(currentNumber - s);
                currentIndex--;
                if(currentIndex >= 0) {
                    currentNumber = a[currentIndex];
                }

            }
        } else {
            while (currentNumber < s && currentIndex < n) {

                count += Math.abs(currentNumber - s);
                currentIndex++;
                if(currentIndex < n) {
                    currentNumber = a[currentIndex];
                }

            }
        }
        System.out.println(count);
    }
}
