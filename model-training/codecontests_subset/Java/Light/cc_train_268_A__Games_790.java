import java.util.HashSet;
import java.util.Scanner;


public class problem1 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] home = new int[n];
        int[] guest = new int[n];
        int ctr = 0;
        for(int i = 0; i < n; i++) {
            home[i] = sc.nextInt();
            guest[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(home[i] == guest[j]) {
                    ctr++;
                }
            }
        }
        System.out.println(ctr);

    }
}



