import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class C {
    static final long MODULO =  (long)1e9 + 7;


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        long factorial = 1;
        for(long i = 2; i <= n; i++) {
            factorial = ((factorial % MODULO) * (i % MODULO)) % MODULO;
        }
        long badGuys = 2;
        for(long i = n - 2; i >= 1; i--) {
            badGuys = (badGuys % MODULO + badGuys % MODULO) % MODULO;
        }
        long res = ((factorial % MODULO) - (badGuys % MODULO)) % MODULO;
        if(res < 0) res += MODULO;
        System.out.println(res);
    }
}
