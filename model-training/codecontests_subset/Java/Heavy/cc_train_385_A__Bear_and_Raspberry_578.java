import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BearAndRaspberry {
    int N;
    int C;
    int[] rates;
    public static void main(String[] args) {
        BearAndRaspberry andRaspberry = new BearAndRaspberry();
        andRaspberry.read();
        andRaspberry.solve();
    }
    
    void read() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            String[] s = br.readLine().split(" ");
            N = Integer.parseInt(s[0]);
            C = Integer.parseInt(s[1]);
            
            s = br.readLine().split(" ");
            rates = new int[s.length];
            for (int i = 0; i < rates.length; i++) {
                rates[i] = Integer.parseInt(s[i]);
            }
        } catch (Exception e) {
        }
    }
    
    void solve() {
        int res = 0;
        for (int i = 0; i + 1 < rates.length; i++) {
            res = Math.max(res, rates[i] - rates[i + 1]);
        }
        
        res -= C;
        System.out.println((res >= 0) ? res : 0);
    }
}