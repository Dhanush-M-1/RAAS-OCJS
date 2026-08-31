//package juniortraining;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] home = new int[n];
        int[] guest = new int[n];

        for (int i = 0; i < n; ++i) {
            home[i] = in.nextInt();
            guest[i] = in.nextInt();
        }
        
        int count = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(home[i] == guest[j])
                    ++count;
            }
        }
        
        System.out.println(count);
    }
}
