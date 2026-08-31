import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class B {
        static InputReader in;
        static PrintWriter out;
        static int[] A;
        static int[] B;
        static int[] C;
        
    public static void main(String[] args) {
        in= new InputReader(System.in);
        out= new PrintWriter(System.out,true);
        String a= in.next();
        String b= in.next();
        String c= in.next();
        A= new int[26];
        B= new int[26];
        C= new int[26];
        String d= "qwertyuiopasdfghjklzxcvbnm";
        for(int i=0; i<a.length(); i++){
            A[ a.charAt(i)-97]++;
        }
        for(int i=0; i<b.length(); i++){
            B[ b.charAt(i)-97]++;
        }
        for(int i=0; i<c.length(); i++){
            C[ c.charAt(i)-97]++;
        }
        
        int maxX=0;
        int maxY=0;
        int x=0;
        mainLoop:
        while(true){
            //out.println("x equals : " + x);
            int y=Integer.MAX_VALUE;
            for(int i=0; i<26; i++){
            if(A[i]- x*B[i] < 0) {break mainLoop;}
            }
            for(int i=0; i<26; i++){
                if((A[i] - x* B[i]) < C[i]){
                    y=0;
                    break;
                }
                if(C[i] !=0){
                int t= (A[i]- x*B[i])/C[i];
                if(t<y){
                    y=t;
                }
                }
            }
            if((x+y)>(maxX+maxY)){
                maxX=x;
                maxY=y;
            }
            x++;
        }
        StringBuilder s= new StringBuilder();
        for(int i=0; i<maxX; i++){
            s.append(b);
        }
        for(int i=0; i<maxY; i++){
            s.append(c);
        }
        for(int i=0; i<26; i++){
            A[i]-= (maxX*B[i]+maxY*C[i]);
        }
        for(int i=0; i<26; i++){
            for(int j=0; j<A[i]; j++){
                s.append( Character.toString((char) (i+97)));
            }
        }
        
        out.println(s);
        
        out.close();
        System.exit(0);
        
    }
    
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
          reader = new BufferedReader(new InputStreamReader(stream), 32768);
          tokenizer = null;
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

        public int nextInt() {
          return Integer.parseInt(next());
        }
        
        public long nextLong() {
              return Long.parseLong(next());
        }
 }
}
