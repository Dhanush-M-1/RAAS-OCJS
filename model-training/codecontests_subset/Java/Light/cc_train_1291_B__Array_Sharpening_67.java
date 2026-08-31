import java.util.*;
/*
         #  #  #    #    #         #         #      ##      #    #
         #  #  #    #    #         #         #     #  #     ##  ##
         #  #  #    #    #         #         #    #    #    # ## #
         #  #  #    #    #         #         #    ######    #    #
         #  #  #    #    #         #         #    #    #    #    #
          ## ##     #    ######    ######    #    #    #    #    #
 */
public class Problem1291b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int max = 0;
            int min = n-1;
            for(int i = 0; i < n; i++) {
                int a = sc.nextInt();
                if(a < i) {
                    min = Math.min(min, i-1);
                }
                if(a < n - i - 1){
                    max = i+1;
                }
            }
            System.out.println(min >= max ? "Yes" : "No");
        }
    }

}