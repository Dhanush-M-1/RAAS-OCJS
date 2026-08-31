import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        var sc = new Scanner(System.in);
    
        int T = Integer.parseInt(sc.next());
        var pw = new PrintWriter(System.out);
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(sc.next());
            int m = Integer.parseInt(sc.next());
            var set = new HashSet<Integer>();
            for(int i = 0; i < n; i++){
                int a = Integer.parseInt(sc.next());
                set.add(a);
            }
            int ans = -1;
            for(int i = 0; i < m; i++){
                int b = Integer.parseInt(sc.next());
                if(ans == -1 && set.contains(b)){
                    ans = b;
                }
            }
            if(ans == -1){
                pw.println("NO");
            }else{
                pw.println("YES");
                pw.println("1 " + ans);
            }
        }
        pw.flush();
    }
}