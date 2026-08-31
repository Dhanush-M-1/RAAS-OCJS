import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class problem3 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long X = Long.parseLong(reader.readLine());
        long max = -1;
        long min = -1;
        for(long i = 2; i <= Math.sqrt(X);i++){
            if(X % i == 0){
                BigInteger a = BigInteger.valueOf(i);
                BigInteger b = BigInteger.valueOf(X).divide(a);
                if(a.gcd(b).equals(BigInteger.ONE)) {
                    long max_ = a.max(b).longValue();
                    if(max == -1){
                        max = max_;
                        min = a.min(b).longValue();
                    }else{
                        if (max_ < max) {
                            max = max_;
                            min = a.min(b).longValue();
                        }
                    }
                    
                }
            }
        }
        if(max == -1){
            System.out.println(1+" "+X);
        }else{
            System.out.println(min+" "+max);
        }

    }
}
