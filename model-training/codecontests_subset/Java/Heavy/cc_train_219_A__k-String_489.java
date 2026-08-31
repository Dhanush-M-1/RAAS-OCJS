import java.util.Scanner;
import java.io.OutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author @Ziklon
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskA {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int C[]=new int[26];
        int K=in.nextInt();
        String s=in.next();
        for(char c : s.toCharArray())C[c-'a']++;

        String ans="";
        String res="";
        for(int i=0;i<26;i++){
            if(C[i]>0 && C[i]%K!=0){
                out.println(-1);
                return;
            }
            ans+=getNString(C[i]/K,(char)('a'+i));
        }
        for(int i=0;i<K;i++)res+=ans;
        out.println(res);


    }

    private String getNString(int n, char c){
        String res="";
        while (res.length()<n)res+=c;
        return res;
    }
}
