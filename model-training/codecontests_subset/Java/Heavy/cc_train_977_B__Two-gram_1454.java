import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        Set<String> towGrams = new HashSet<>();
        int n;
        String word;
        n = in.nextInt();
        word = in.next();
        
        for(int i =0;i < n-1;i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(i));
            sb.append(word.charAt(i+1));
            towGrams.add(sb.toString());
            }
        
        ArrayList<String> towGramsList = new ArrayList<>(towGrams);
        int counting[] = new int[100];
        for(int i =0;i < n-1;i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(word.charAt(i));
            sb.append(word.charAt(i+1));
            for(int j  =0; j < towGramsList.size();j++) {
                if(sb.toString().equals(towGramsList.get(j))) {
                    counting[j]++;
                    
                }
            }
        }
        
        int max = 0;
        int index = -1;
        for(int i =0; i < counting.length;i++) {
            if(counting[i] > max) {
                max = counting[i];
                index = i;
            }
            
                
        }
        
        System.out.println(towGramsList.get(index));
    
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
