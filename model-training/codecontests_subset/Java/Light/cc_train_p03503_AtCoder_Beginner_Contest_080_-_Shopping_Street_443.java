import java.util.*;
 
public class Main{
    static int[] joi;
    static int[][] F;
    static int max;
    static int N;
    static int[][] P;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        F = new int[N][10];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 10; j++){
                F[i][j] = sc.nextInt();
            }
        }
        P = new int[N][11];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 11; j++){
                P[i][j] = sc.nextInt();
            }
        }
        sc.close();
        joi = new int[10];
        max = Integer.MIN_VALUE;
        dps(0);
        System.out.println(max);
    }
    static void dps(int pos){
        if(pos == 10 && !(isEmpty())){
            int sum = 0;
            for(int i = 0; i < N; i++){
                sum += P[i][count(i)];
            }
            max = Math.max(max, sum); 
        }
        if(pos < 10){
            joi[pos] = 0;
            dps(pos+1);
            joi[pos] = 1;
            dps(pos+1);
        }
    }

    static boolean isEmpty(){
        for(int i = 0; i < 10; i++){
            if(joi[i] != 0)
                return false;
        }
        return true;
    }

    static int count(int n){
        int count = 0;
        for(int i = 0; i < 10; i++){
            if(joi[i] == 1 && F[n][i] == 1)
                count++;
        }
        return count;
    }
}