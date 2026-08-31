import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Codeforces {
    
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    
    private static final int MOD = 998244353;
    
    public static void main(String[] args) {
        FastReader input = new FastReader();
        int n = input.nextInt();
        ArrayList<ArrayList<Integer>> listDigits = new ArrayList<>();
        long ans = 0;
        
        for (int i = 0; i < 10; i++){
            listDigits.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++){
            int[] digits = toDigits(input.nextLong());
            for (int j = 0; j < digits.length; j++) listDigits.get(j).add(digits[j]);
        }
        
        int[] numKDigits = new int[10];
        
        for (int i = 0; i < 10; i++){
            if (i < 9) numKDigits[i] = listDigits.get(i).size() - listDigits.get(i + 1).size();
            else numKDigits[i] = listDigits.get(i).size();
        }
        
        int count = 0;
        long pow = 1;
        
        for (ArrayList<Integer> al : listDigits){
            long powpow = 1;
            long sumDigits = 0;
            
            for (int x : al) sumDigits += x;
            
            for (int i = 0; i < 10; i++){
                
                long temp;
                
                if (i < count){
                    powpow *= 10;
                    temp = (2 * numKDigits[i] * sumDigits) % MOD;
                    temp = (temp * pow) % MOD;
                    temp = (temp * powpow) % MOD;
                    ans = (ans + temp) % MOD;
                }else{
                    temp = (11 * numKDigits[i] * sumDigits) % MOD;
                    temp = (temp * pow) % MOD;
                    temp = (temp * powpow) % MOD;
                    ans = (ans + temp) % MOD;
                }
                
            }
            
            
            
            
            count++;
            pow *= 10;
        }
        
        System.out.println(ans);
        
        //TESTING
        
//        for (ArrayList<Integer> al : listDigits){
//            for (int x : al) System.out.print(x + " ");
//            System.out.println();
//        }
//        
//        System.out.println("\n");
//        
//        for (int x : numKDigits) System.out.print(x + " ");
//
//        System.out.println("\n");
    }
    
    private static int[] toDigits (long k){
        long t = k;
        long pow = 1;
        int power = 0;
        while(pow <= t){
            pow *= 10;
            power++;
        }
        int[] ans = new int[power];
        power = 0;
        for (;power < ans.length; power++){
            ans[power] = (int) (t % 10);
            t = t / 10;
        }
        return ans;
    }
}