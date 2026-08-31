import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long n = Long.parseLong(tokenizer.nextToken());
        long p = Long.parseLong(tokenizer.nextToken());
        long w = Long.parseLong(tokenizer.nextToken());
        long d = Long.parseLong(tokenizer.nextToken());
        long x = -1;
        long y = -1;
        if(p == 0){
            System.out.println(0+" "+0+" "+n);
            return;
        }
        if(p % d == 0){
            y = p/d;
            if(y <= n){
                System.out.println(0+" "+y+" "+(n-y));
                return;
            }
        }
        for (long i = 0; i <= w && (p - i*d >= w); i++) {
            if((p - i*d) % w == 0){
                x = (p - i*d)/w;
                y = i;
                if(x + y <= n){
                    System.out.println(x+" "+y+" "+(n-x-y));
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
