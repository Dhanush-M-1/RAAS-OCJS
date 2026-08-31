
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] vet = new int[n + 1];
        int soma = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {

            vet[i] = Integer.parseInt(st.nextToken());
            soma += vet[i];
        }

        int suporta = soma / 2;

        int dp[][] = new int[n + 1][suporta + 1];

        for (int x = 1; x <= n; x++) {

            for (int j = 1; j <= suporta; j++) {

                if (vet[x] <= j) {
                    dp[x][j] = Math.max(vet[x] + dp[x - 1][j - vet[x]], dp[x - 1][j]);

                } else {
                    dp[x][j] = dp[x - 1][j];

                }

            }

        }
        
        int tt = soma - dp[n][suporta];
        
        if(tt == dp[n][suporta]){
        
            sb.append("YES\n");
        }else{
        
             sb.append("NO\n");
        }

        

        bw.write(sb.toString());
        bw.flush();
    }

}
