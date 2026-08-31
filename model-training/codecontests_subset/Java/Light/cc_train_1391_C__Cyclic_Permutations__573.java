import java.io.*;

public class CyclicPermutations {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        double MOD = 1e9+7;
        double res = 1;
        double fact = 1;
        for(double i=1;i<=n-1;i++){
            res *= 2;
            fact *= i;
            fact %= MOD;
            res %= MOD;
        }
        fact *= n;
        fact %= MOD;
        fact -= res;
        fact %= MOD;
        if(fact < 0) fact += MOD;
        System.out.println(String.format("%.0f", fact));
    }
}