import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskD {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
       String str=in.nextLine();
        int n=in.nextInt();
        str=str.toLowerCase();
        String ans="";
        for (int i=0;i<str.length();i++){

            if(str.charAt(i)<'a'+n)
                ans+=(char)(str.charAt(i)-32);
            else ans+=str.charAt(i);
        }
        out.println(ans);
    }
}

