
import java.io.*;
import java.util.*;

public class C107{      
        
        private BufferedReader in;  
        private StringTokenizer st;
        
        long a;
        long x;
        boolean canWin(long n){
            if(n == 1) return true;
            
            boolean can = false;
            boolean div = false;
            for (long i = 2; i*i <= n; i++) {               
                if(n%i == 0){
                    div = true;
                    if(!canWin(i)){
                        if(n == x) a = i;
                        can = true;
                        break;
                    }
                    if(!canWin(n/i)){
                        if(n == x) a = n/i;
                        can = true;
                        break;
                    }
                }
            }           
            if(!div) return true;
            return can;
        }
        int countFactors(long a){
            int ans = 0;
            for (long i = 2; i*i <=a ; i++) {
                while(a %i == 0){
                    a/=i;
                    ans++;
                }
            }
            if(a != 1 ) ans++;
            return ans;
        }
        void solve() throws IOException{

            x = nextLong();
            int c = countFactors(x);
            if(c == 0 || c == 1){
                System.out.println(1);
                System.out.println(0);
            }
            else if(c == 2){
                System.out.println(2);
            }
            else{
                System.out.println(1);
                for (long i = 2; i*i <= x; i++) {
                    if(x%i == 0){
                        if(countFactors(i) == 2){System.out.println(i); break;}
                        if(countFactors(x/i)==2) {System.out.println(x/i); break;}
                    }
                }
            }
            
        }
            

        C107() throws IOException {
            in = new BufferedReader(new InputStreamReader(System.in));          
            eat("");
            solve();            
        }

        private void eat(String str) {
            st = new StringTokenizer(str);
        }

        String next() throws IOException {
            while (!st.hasMoreTokens()) {
                String line = in.readLine();
                if (line == null) {
                    return null;
                }
                eat(line);
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public static void main(String[] args) throws IOException {
            new C107();
        }

        int gcd(int a,int b){
            if(b>a) return gcd(b,a);
            if(b==0) return a;
            return gcd(b,a%b);
        }

}
