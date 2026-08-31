import java.io.*;
import java.util.*;

public class Chat {
    
    private void solve() throws IOException {
        String s = "";
        long res = 0;
        int count = 0;
        while(true){
            try{
                s = stdin.readLine();
                if(s.charAt(0)=='+') {
                    count++;
                }else if (s.charAt(0)=='-'){
                    count--;
                }else{
                    String [] f = s.split("[:]+");
                    if (f.length > 1)
                        res += (long)count * f[1].length();
                }
            }catch(Exception e){
                break;
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) throws IOException {
        new Chat().run1();
    }

    BufferedReader stdin;
    PrintWriter out;

    public void run1() throws IOException {
        stdin = new BufferedReader(new InputStreamReader(System.in));
        solve();
        stdin.close();
    }

    public void run2() throws IOException {
        stdin = new BufferedReader(new FileReader(".in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(".out")));
        solve();
        out.close();
        stdin.close();
    }
}
