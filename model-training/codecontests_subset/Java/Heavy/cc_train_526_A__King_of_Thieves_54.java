import java.io.*;
import java.util.Scanner;

/**
 * Author: Sergey Paramonov
 * Date: 04.04.15
 * Time: 20:05
 */
public class Zepto_20150404_A {

    Scanner scanner = new Scanner(System.in);
    BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
    StreamTokenizer input = new StreamTokenizer(buffered);

    PrintWriter output = new PrintWriter(new BufferedOutputStream(System.out));

    int nextInt() throws Exception {
        input.nextToken();
        return (int) input.nval;
    }

    void flushAndClose() {
        output.flush();
        System.out.flush();
        output.close();
    }

    void main() throws Exception {
        int n = Integer.valueOf(buffered.readLine());
        String s = buffered.readLine();
        boolean bingo = false;
        for (int p = 1; p*4 < n; p++) {
            for (int i = 0; i + 4*p < n; i++) {
                if (s.charAt(i) == '*' && s.charAt(i+p) == '*' && s.charAt(i+2*p) == '*' && s.charAt(i+3*p) == '*' && s.charAt(i+4*p) == '*') {
                    bingo = true;
                    break;
                }
            }
        }
        output.println(bingo ? "yes" : "no");
        flushAndClose();
    }

    public static void main(String[] args) throws Exception {
        new Zepto_20150404_A().main();
    }

}
