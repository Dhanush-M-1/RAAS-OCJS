//package codeforces.ru.task_260B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by myduomilia on 21.09.14.
 */
public class Main {

    private static int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static boolean test(String str){
        StringTokenizer token = new StringTokenizer(str, "-");
        int d = -1;
        if(token.hasMoreTokens()){
            String s = token.nextToken();
            if(s.length() == 2)
                d = Integer.parseInt(s);
        }
        int m = -1;
        if(token.hasMoreTokens()){
            String s = token.nextToken();
            if(s.length() == 2)
                m = Integer.parseInt(s);
        }
        int y = -1;
        if(token.hasMoreTokens()){
            String s = token.nextToken();
            if(s.length() == 4)
                y = Integer.parseInt(s);
        }
        if(y < 2013 || y > 2015)
            return false;
        if(m < 1 || m > 12)
            return false;
        if(d < 1 || d > month[m - 1])
            return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        FastReadWriteConsole console = new FastReadWriteConsole();
        String str = console.nextString();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length() - 9; i++){
            String s = str.substring(i, i + 10);
            if(test(s)){
                if(!map.containsKey(s))
                    map.put(s, 1);
                else
                    map.put(s, map.get(s) + 1);
            }
        }
        String ans = "";
        int c = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(entry.getValue() > c){
                ans = entry.getKey();
                c = entry.getValue();
            }
        }
        console.print(ans);
        console.close();
    }
}
class FastReadWriteConsole {

    BufferedReader in;
    StringTokenizer tok;
    PrintWriter out;

    public FastReadWriteConsole() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    private String readToken() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(readToken());
    }

    public String nextString() throws IOException {
        return readToken();
    }

    public void print(Object obj){
        out.print(obj.toString());
    }

    public void close() throws IOException {
        in.close();
        out.close();
    }

}
