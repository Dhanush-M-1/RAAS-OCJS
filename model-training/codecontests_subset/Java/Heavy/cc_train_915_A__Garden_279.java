
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
 public static void main(String[] args) throws java.lang.Exception {
        FastReader read = new FastReader() ; 
        int n = read.nextInt() ; 
        int k = read.nextInt(); 
        int arr[] = new int [n]; 
        for (int i = 0; i < arr.length; i++) {
         arr[i]= read.nextInt() ; 
     }
        Arrays.sort(arr);
       for (int i = arr.length-1; i >=0; i--) {
         if(k%arr[i]==0){
             System.out.println(k/arr[i]);
             System.exit(0);
         }
     }
 
    }}
    
class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}