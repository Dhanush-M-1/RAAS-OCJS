import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int[] ar = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            ar[i] = sc.nextInt();
        }
        for (int i = 1; i < N+1; i++) {
            int P = ar[i];
            if (i == P) {
                i++;
                count++;
            }
        }
        System.out.println(count);
    }    
}
