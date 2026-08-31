

import java.util.*;
import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {
        Output out = new Output();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        String pw = st.nextToken();
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        HashSet<String> words = new HashSet<String>();
        for (int i=0 ; i<n ; ++i) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            words.add(s);
        }
        
        HashSet[] vocab = (HashSet<Character>[]) new HashSet[26];
        for (String word : words) {
            vocab[word.charAt(1)-'a'] = new HashSet<Character>();
        }
        for (String word : words) {
            for (HashSet<Character> set : vocab) {
                if (set == null) continue;
                
                set.add(word.charAt(0));
            }
        }
        
        for (String word : words) {
            if (pw.equals(word)) {
                out.println("YES");
                out.flush();
                return;
            }
        }
        if (vocab[pw.charAt(0)-'a'] != null && vocab[pw.charAt(0)-'a'].contains(pw.charAt(1))) {
            out.println("YES");
            out.flush();
            return;
        }
        
        out.println("NO");
        out.flush();
        return;
    }
}


class Output {
    private BufferedWriter out;

    Output() {
        this.out = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    void print(String s) throws IOException {this.out.write(s);}
    void println(String s) throws IOException {this.out.write(s + "\n");}
    void println(long n) throws IOException {this.out.write(n + "\n");}
    void println(int n) throws IOException {this.out.write(n + "\n");}
    void flush () throws IOException {this.out.flush();}
}