

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputstr;
        int N = Integer.parseInt(br.readLine().trim());
        int[][] F = new int[N][10];
        int[][] P = new int[N][11];
        for(int i=0; i<N; i++){
            inputstr = br.readLine().trim().split(" ");
            F[i][0] = Integer.parseInt(inputstr[0]);
            F[i][1] = Integer.parseInt(inputstr[1]);
            F[i][2] = Integer.parseInt(inputstr[2]);
            F[i][3] = Integer.parseInt(inputstr[3]);
            F[i][4] = Integer.parseInt(inputstr[4]);
            F[i][5] = Integer.parseInt(inputstr[5]);
            F[i][6] = Integer.parseInt(inputstr[6]);
            F[i][7] = Integer.parseInt(inputstr[7]);
            F[i][8] = Integer.parseInt(inputstr[8]);
            F[i][9] = Integer.parseInt(inputstr[9]);
        }
        for(int i=0; i<N; i++){
            inputstr = br.readLine().trim().split(" ");
            for(int j=0; j<11; j++){
                P[i][j] = Integer.parseInt(inputstr[j]);
            }
        }
        int a = 1;
        String a_bin;
        int maxprofit = Integer.MIN_VALUE;
        int temp;
        int[] count = new int[N];
        for(a=1; a<= 1024; a++){
            temp = 0;
            for(int i=0; i<count.length; i++){
                count[i] = 0;
            }
            a_bin = Integer.toBinaryString(a);
            while(a_bin.length() < 10){
                a_bin = "0" + a_bin;
            }
            for(int i=0; i<10; i++){
                if(a_bin.charAt(i) == '1'){
                    for(int j=0; j<N; j++){
                        if(F[j][i] == 1) count[j]++;
                    }
                }
            }
            for(int i=0; i<N; i++){
                temp += P[i][count[i]];
            }
            maxprofit = Math.max(maxprofit, temp);
        }
        System.out.println(maxprofit);
    }
}