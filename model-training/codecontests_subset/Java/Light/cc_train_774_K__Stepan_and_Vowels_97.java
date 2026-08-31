import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {

    static void solve(){
        read();
        write(read().replaceAll("(?<=(a|y|u|i))\\1+|(?<=(e|o))\\2{2,}",""));
    }

    static PrintWriter pw=new PrintWriter(System.out);
    static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st=new StringTokenizer(""," ");
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
