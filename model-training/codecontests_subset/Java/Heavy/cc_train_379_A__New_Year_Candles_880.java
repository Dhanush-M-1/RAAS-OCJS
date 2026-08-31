import java.io.PrintWriter;
import java.util.Scanner;

public class A {
    static Scanner in; static int next() throws Exception {return in.nextInt();};
    //	static StreamTokenizer in; static int next() throws Exception {in.nextToken(); return (int) in.nval;}
//	static BufferedReader in;
    static PrintWriter out;


    public static void main(String[] args) throws Exception {
        in = new Scanner(System.in);
//		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//		in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        int a = next(), b = next();
        int res = a, d = 0;
        while (a >= b) {
            res += a/b;
            a = a%b + a/b;
        }
        out.println(res);


        out.close();
    }
}