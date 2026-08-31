import java.util.*;
import java.io.*;

public class C2 {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(f.readLine());
        while(t-->0){
            int n = Integer.parseInt(f.readLine());
            out.println(1.0/(2.0*Math.sin(Math.PI/(4.0 * n))));


        }


        out.close();
    }
}
