import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[2][n];
        int[][] c = new int[2][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < 2 ; j++){
                a[j][i] = sc.nextInt();
            }
        }
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < 2 ; j++){
                c[j][i] = sc.nextInt();
            }
        }
        for(int i = 0 ; i < n ; i++){
            int yono = 0;
            for(int j = 0 ; j < m ; j++){
                if(Math.abs(c[0][yono] - a[0][i]) + Math.abs(c[1][yono] - a[1][i]) > Math.abs(c[0][j] - a[0][i]) + Math.abs(c[1][j] - a[1][i])){
                    yono = j;
                }
            }
            System.out.println(yono + 1);
        }
    }
}
//鶏になれ
