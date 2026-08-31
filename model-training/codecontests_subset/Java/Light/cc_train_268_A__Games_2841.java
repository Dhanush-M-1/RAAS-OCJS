import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        int[] array = new int[n];
        int[] array2 = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = console.nextInt();
            array2[i] = console.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (array[i] == array2[j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}