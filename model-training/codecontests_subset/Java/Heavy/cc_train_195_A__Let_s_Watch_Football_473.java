    import java.util.*;
    import java.io.*;
    public class Main {
        public static long mod= (long) (1e9 +7);
        public static void main(String args[]){
            InputReader s= new InputReader(System.in);
            OutputStream outputStream= System.out;
            PrintWriter out= new PrintWriter(outputStream);
            int a= s.nextInt();
            int b= s.nextInt();
            int c= s.nextInt();
            int temp= a*c;
            int temp1= (int) Math.ceil((float)temp/(float)b);
            //out.println(temp1);
            int ans= temp1- c;
            out.println(ans);
            out.close();
        }
        static class InputReader {
    
            public BufferedReader reader;
            public StringTokenizer tokenizer;
     
            public InputReader(InputStream inputstream) {
              reader = new BufferedReader(new InputStreamReader(inputstream));
              tokenizer = null;
            }
            
            public String nextLine(){
                String fullLine=null;
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    try {
                      fullLine=reader.readLine();
                    } catch (IOException e) {
                      throw new RuntimeException(e);
                    }
                    return fullLine;
                  }
                  return fullLine;
            }
            public String next() {
              while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                  tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                  throw new RuntimeException(e);
                }
              }
              return tokenizer.nextToken();
            }
            public long nextLong() {
                  return Long.parseLong(next());
                }
            public int nextInt() {
              return Integer.parseInt(next());
            }
          }
        public static int gcd(int number1, int number2) {  
            if(number2 == 0){
                return number1;
            } 
            return gcd(number2, number1%number2); 
        }
        public static int combinations(int n,int r){
            if(n==r) return 1;
            if(r==1) return n;
            if(r==0) return 1;
            return combinations(n-1,r)+ combinations(n-1,r-1);
        }
    
        public static int expo(int a, int b){
            if (b==1)
                return a;
            if (b==2)
                return a*a;
    
            if (b%2==0){
                    return expo(expo(a,b/2),2);
            }
            else{
                return a*expo(expo(a,(b-1)/2),2);
            }
        }
        
        public static void sieve(int N){
            int arr[]= new int[N+1];
            for(int i=2;i<Math.sqrt(N);i++){
                if(arr[i]==0){
                    for(int j= i*i;j<= N;j= j+i){
                        arr[j]=1;
                    }
                }
            }
            // All the i for which arr[i]==0 are prime numbers.
        }
    }
    
