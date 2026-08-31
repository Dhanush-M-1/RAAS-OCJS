import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    private static StreamTokenizer in;
    private static PrintWriter out;
    private static BufferedReader inB;
    
    private static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    
    private static String nextString() throws Exception{
        in.nextToken();
        return in.sval;
    }
    
    static{
        inB = new BufferedReader(new InputStreamReader(System.in));
        in = new StreamTokenizer(inB);
        out = new PrintWriter(System.out);
    }
    
    public static void main(String[] args)throws Exception {
        String[] ss = inB.readLine().split(" ");
        int t = Integer.parseInt(ss[0]), m = Integer.parseInt(ss[1]);
        
        int[] mem = new int[m];
        
        int indcount = 1;
        
    m:  for(int _ = 0; _<t; _++) {
            ss = inB.readLine().split(" ");
            
            if(ss[0].equals("alloc")) {
                int n = Integer.parseInt(ss[1]);
                
                for(int i = 0; i<m; i++) {
                    if(mem[i] != 0)continue;
                    boolean end = false;
                    int curCount = 0;
                    for(int j = i; j<m; j++) {
                        if(mem[j] != 0)break;
                        curCount++;
                        if(curCount >= n)break;
                        if(j == m-1)end = true;
                    }
                    
                    if(curCount < n) {
                        if(end) {
                            out.println("NULL");
                            continue m;
                        }
                        continue;
                    }
                    
                    int curind = indcount++;
                    for(int j = i; j<i+n;j++) {
                        mem[j] = curind;
                    }
                    out.println(curind);
                    continue m;
                }
                out.println("NULL");
                
            } else if(ss[0].equals("erase")) {
                int n = Integer.parseInt(ss[1]);
                
                
                boolean find = false;
                for(int i = 0; i<m; i++) {
                    if(mem[i] == n) {
                        mem[i] = 0;
                        find = true;
                    }
                }
                if(n == 0 || !find) {
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } else {
                for(int i = 0; i<m; i++) {
                    if(mem[i] != 0)continue;
                    int find = -1;
                    for(int j = i; j<m; j++) {
                        if(mem[j] != 0) {
                            find = mem[j];
                            mem[j] = 0;
                            break;
                        }
                    }
                    if(find == -1)break;
                    mem[i] = find;
                }
            }
        }
        
        out.flush();
    }
    
}
