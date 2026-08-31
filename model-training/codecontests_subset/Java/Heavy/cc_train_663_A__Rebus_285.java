
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class CodeForces {

    private static int count = 1;
    private static int count2;

    public static void main(String args[]) throws IOException {
        Reader.init(System.in);
        PrintWriter write = new PrintWriter(System.out);
        String line = Reader.reader.readLine();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '+') {
                count++;
            } else if (line.charAt(i) == '-') {
                count2++;
            }
        }

        int n = Integer.parseInt(line.substring(line.indexOf("=") + 2));
        int num = (count2 + n) / count;
        int rem = (count2 + n) % count;

        if(num > n || (num + 1 > n && rem != 0))
            write.print("Impossible");
        
        else {
            
            int zero = 0, xRem = 0, x = 1;
            
            
        if(num == 0){
            zero = count - rem;
            if(count2 != 0){
                x = zero / count2 + 1;
                 xRem = zero % count2;
            }
            
            if(x > n || (x + 1 > n && xRem!=0) || count2 == 0){
                write.print("Impossible");
                write.close();
                return;
            }
        
        }
            write.print("Possible\n");
            
            write.print(num + (rem > 0 ? 1 : 0));
            for (int i = 1; i < line.length(); i++) {
                if(line.charAt(i) == '?'){
                    if(line.charAt(i-2) == '-')
                        write.print(x + (xRem-- > 0 ? 1 : 0));
                    else{
                        int h = num;
                        rem--;
                        if(rem > 0)
                            h++;
                        else if(zero > 0){
                            h++;
                            zero--;
                        }
                        
                        write.print(h);
                    }
                }
                else
                    write.print(line.charAt(i));
            }
        }
        
        write.close();
    }
}

class Pair {

    int x, y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Pair p = (Pair) o;
        return (p.x == x && p.y == y) || (p.x == y || p.y == x);
    }

    @Override
    public int hashCode() {

        return ((x + 1) * (y + 1)) % ((int) 1e7 + 7);
    }

}

class Reader {

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    public static int pars(String x) {
        int num = 0;
        int i = 0;
        if (x.charAt(0) == '-') {
            i = 1;
        }
        for (; i < x.length(); i++) {
            num = num * 10 + (x.charAt(i) - '0');
        }

        if (x.charAt(0) == '-') {
            return -num;
        }

        return num;
    }

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }

    static void init(FileReader input) {
        reader = new BufferedReader(input);
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return pars(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
}
