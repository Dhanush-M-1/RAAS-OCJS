/**
 * Created by IntelliJ IDEA.
 * User: shakhov
 * Date: 15.06.2011
 * Time: 15:22:46
 * To change this template use File | Settings | File Templates.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CodeForces {

    public void solve() throws IOException {
        List<String> part = new ArrayList<String>();

        int counter = 0;
        do {
            String s = reader.readLine();
            if (s.charAt(0) == '+') {
                part.add(s.substring(1));
            } else if (s.charAt(0) == '-') {
                part.remove(s.substring(1));
            } else {
                int x = s.indexOf(":");
                if (x < s.length() - 1) {
                    s = s.substring(x + 1);
                    counter += s.length() * part.size();
                }
            }
        }
        while (reader.ready());


        writer.print(counter);
    }


    public static void main(String[] args) {
        new CodeForces().run();
    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter writer;

    public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            //reader = new BufferedReader(new FileReader("LifeWithoutZeros.in"));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            //writer = new PrintWriter(new BufferedWriter(new FileWriter("LifeWithoutZeros.out")));
            //long t=new Date().getTime();
            solve();
            //writer.println(t-new Date().getTime());
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}
