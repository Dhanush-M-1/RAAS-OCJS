import java.util.*;

public class Main {

    public static void main( String[] argv ) throws Exception {
        String  line;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int k0 = 0;
        int[] arr = new int[100];
        for (int i=0;i < N;i++) {
            arr[i] = sc.nextInt();
            k0 = Math.max(k0, arr[i]);
        }

        for (int k=k0;k <= 1000000;k++) {
            int Awruk = 0;
            int Elodreip = 0;

            for (int i=0;i < N;i++) {
                Elodreip += arr[i];
                Awruk += k - arr[i];
            }

            if (Awruk > Elodreip) {
                System.out.print(k);
                return;
            }
        }
    }
}