import java.io.BufferedReader;
import java.io.InputStreamReader;

public class c {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        int rem = (int) Math.pow(10, 9) + 7;
        long comb = 1;
        long factorial = 1;
        for(int i=1;i<n;i++){
            comb = (comb * 2) % rem;
            factorial = (factorial * i) % rem;            
        }

        factorial = (factorial * n) % rem;
        long res = (factorial - comb + rem) % rem;
        System.out.println(res);
    }
}