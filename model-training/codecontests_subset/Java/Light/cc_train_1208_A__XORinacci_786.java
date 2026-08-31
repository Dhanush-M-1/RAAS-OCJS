import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    static PrintWriter pw=new PrintWriter(System.out);
    static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st=new StringTokenizer(""," ");
    static void solve(){
        int T=Integer.parseInt(read());
        for (int i = 0; i < T; i++) {
            long a=Integer.parseInt(read());
            long b=Integer.parseInt(read());
            long n=Integer.parseInt(read());
            switch((int)(n%3)){
                case 0:writeln(a);break;
                case 1:writeln(b);break;
                case 2:writeln(a^b);break;
            }
        }
    }
    public static void main(String... args){
        solve();
        pw.flush();
    }
    static String read() {
        try {
            if(st.hasMoreTokens())
                return st.nextToken();
            st=new StringTokenizer(bf.readLine()," ");
            if(st.hasMoreTokens())
                return st.nextToken();
        }
        catch (IOException e){e.printStackTrace();}
        return "";
    }
    static <T> void write(T s) {
        pw.write(String.valueOf(s)+" ");
    }
    static <T> void writeln(T s) {
        pw.write(String.valueOf(s)+"\n");
    }

}
