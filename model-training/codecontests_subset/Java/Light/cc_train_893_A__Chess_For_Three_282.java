import java.util.*;

public class p893A {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int spec = 3;

        int[] winner = new int[n];

        for(int i = 0; i < n; i++){
            winner[i] = in.nextInt();
        }

        for(int y = 0; y < n; y++){
            if (spec == winner[y]) {
                System.out.println("NO");
                System.exit(0);
            }
            spec = 6-spec-winner[y];
        }
        System.out.println("YES");
    }
}
