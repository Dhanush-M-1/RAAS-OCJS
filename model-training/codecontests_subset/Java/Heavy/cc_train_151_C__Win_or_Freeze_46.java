
// Imports
import java.util.*;
import java.io.*;

public class C740 {

    static HashSet<Long> factors;
    public static void loadPrimeFactorization(long n) {
        factors = new HashSet<>();
        
        for(long i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0) {
                factors.add(i);
                factors.add(n/i);
            }
        }
    }
    
    
    
    public static boolean isType(long n) {
        int count = 0;
        for(long i = 2; i <= Math.sqrt(n); i++) {
            if(n%i == 0) {
                count += 2;
            }
        }
        
        return (count == 2);
    }
    
    
    /**
     * @param args the command line arguments
     * @throws IOException, FileNotFoundException 
     */
    public static void main(String[] args) throws IOException, FileNotFoundException {
        
        // TODO UNCOMMENT WHEN ALGORITHM CORRECT
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        
        // BufferedReader f = new BufferedReader(new StringReader("30"));
        
        // TODO code application logic here
        long N = Long.parseLong(f.readLine());
        loadPrimeFactorization(N);
        
        for(long i : factors) {
            if(isType(i)) {
                System.out.println("1");
                System.out.println(i);
                System.exit(0);
            }
        }
        
        if(factors.isEmpty()) {
            System.out.println("1");
            System.out.println("0");
        }
        else {
            System.out.println("2");
        }
    }

}
