import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class e653_1 {
    static PrintWriter out;
    static BufferedReader in;
    static StringTokenizer st;

    public static void main(String[] args) throws FileNotFoundException {
        out = new PrintWriter(System.out);
        in = new BufferedReader(new InputStreamReader(System.in));
        new e653_1().Run();
        out.close();
    }

    String ns() {
        try {
            if (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        } catch (Exception e) {
            return null;
        }
    }

    int nextint() {
        return Integer.valueOf(ns());
    }

    private int n;
    private int k;

//    int inf = (int) Math.pow(2,32)/2 - 1;
    ArrayList<Integer> acceptableA = new ArrayList<>();
    ArrayList<Integer> acceptableB = new ArrayList<>();
    ArrayList<Integer> acceptable = new ArrayList<>();

    public void Run() {
        n = nextint();
        k = nextint();

        int aPos = 0;
        int bPos = 0;
        for(int i = 0; i < n; i++){
            int t = nextint();
            int a = nextint();
            int b = nextint();

            if(a == 1 && b == 1){
                acceptable.add(t);
                aPos++;
                bPos++;
            }
            else if (a == 1){
                aPos++;
                acceptableA.add(t);
            }
            else if (b == 1){
                bPos++;
                acceptableB.add(t);
            }
        }
        if (aPos < k || bPos < k){
            out.println(-1);
            return;
        }
        Collections.sort(acceptableB);
        Collections.sort(acceptableA);

        for(int i = 0; i < Math.min(acceptableA.size(), acceptableB.size()); i++){
            acceptable.add(acceptableA.get(i) + acceptableB.get(i));
        }

        Collections.sort(acceptable);
        int sum = 0;

        for(int i = 0; i < k; i++){
            sum += acceptable.get(i);
        }
        out.println(sum);
    }
}