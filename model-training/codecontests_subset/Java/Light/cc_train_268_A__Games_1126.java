
import java.util.Scanner;

/**
 * Created by cs.ucu.edu.ua on 12/1/2016.
 */
public class Match {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] match = new int[n][2];
        for (int i = 0; i < n; i++){
            for(int j = 0; j<2; j++){
                match[i][j] = sc.nextInt();
            }
        }
        int matches = n*(n-1);
        int clothes = 0;
        while(matches > 0){
            for(int i =0; i < n; i++){
                for(int j =i+1; j < n; j++){
                    if(match[i][0] == match[j][1]){
                        clothes++;
                    }if(match[i][1] == match[j][0]){
                        clothes++;
                    }
                    matches -=2;
                }
            }
        }
        System.out.println(clothes);
    }
}
