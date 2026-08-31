
import java.util.*;
import java.io.*;

public class Codeforces {

public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        
        int k = Reader.nextInt(), arr[] = new int[26];
        String s = Reader.next();
        StringBuilder ans = new StringBuilder(), ptt = new StringBuilder();
        
        if(s.length() % k != 0){
            System.out.println("-1");
            return;
        }
        
        for(int i = 0; i < s.length(); i++)
            arr[s.charAt(i) - 97]++;
        
        for(int i = 0; i < 26; i++){
            if(arr[i] % k != 0){
                System.out.println(-1);
                return;
            }
            
            int x = arr[i] / k;
            char ch = (char)(97 + i);
            
            for(int j = 0; j < x; j++)
                ptt.append(ch);
        }
        
        for(int i = 0; i < k; i++)
            ans.append(ptt);
        
        System.out.println(ans);
    }

}

class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /**
     * call this method to initialize reader for InputStream
     */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    /**
     * get next word
     */
    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static byte nextByte() throws IOException {

        return Byte.parseByte(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
