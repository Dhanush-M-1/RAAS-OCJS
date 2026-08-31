import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] ab = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                ab[i][j] = scan.nextInt();
            }
        }
        int[][] cd = new int[m][2];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < 2; j++){
                cd[i][j] = scan.nextInt();
            }
        }
        int min = Integer.MAX_VALUE;
        int out = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(Math.abs(ab[i][0] - cd[j][0]) + Math.abs(ab[i][1] - cd[j][1]) < min){
                    min = Math.abs(ab[i][0] - cd[j][0]) + Math.abs(ab[i][1] - cd[j][1]);
                    out = j + 1;
                }
            }
            System.out.println(out);
            min = Integer.MAX_VALUE;
            out = 0;
        }
    }
}