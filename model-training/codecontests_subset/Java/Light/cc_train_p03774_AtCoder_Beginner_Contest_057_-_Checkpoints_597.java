import java.util.*;

public class Main{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] a = new int[2][N];
        int[][] c = new int[2][M];
        for(int i = 0; i < N; i++){
            a[0][i] = sc.nextInt();
            a[1][i] = sc.nextInt();
        }
        for(int i = 0; i < M; i++){
            c[0][i] = sc.nextInt();
            c[1][i] = sc.nextInt();
        }
        sc.close();

        for(int i = 0; i < N; i++){
            int min = Math.abs(a[0][i] - c[0][0]) + Math.abs(a[1][i] - c[1][0]);
            int index = 0;
            for(int j = 1; j < M; j++){
                if(min > Math.abs(a[0][i] - c[0][j]) + Math.abs(a[1][i] - c[1][j])){
                    min = Math.abs(a[0][i] - c[0][j]) + Math.abs(a[1][i] - c[1][j]);
                    index = j;
                }
            }
            System.out.println(index+1);
        }
    }
}