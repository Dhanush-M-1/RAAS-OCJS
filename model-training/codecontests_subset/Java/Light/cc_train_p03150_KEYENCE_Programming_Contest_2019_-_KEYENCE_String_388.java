import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
 
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String line = br.readLine();
        boolean res = false;
        if (line.contains("keyence")) {
            String p = line.replace("keyence", "@");
            if (p.startsWith("@") || p.endsWith("@")) {
                res = true;                
            }
        } else if (line.contains("keyenc")) {
            String p = line.replace("keyenc", "@");
            if (p.startsWith("@") && p.endsWith("e")) {
                res = true;                
            }
        } else if (line.contains("keyen")) {
            String p = line.replace("keyen", "@");
            if (p.startsWith("@") && p.endsWith("ce")) {
                res = true;                
            }
        } else if (line.contains("keye")) {
            String p = line.replace("keye", "@");
            if (p.startsWith("@") && p.endsWith("nce")) {
                res = true;                
            }
        } else if (line.contains("key")) {
            String p = line.replace("key", "@");
            if (p.startsWith("@") && p.endsWith("ence")) {
                res = true;                
            }
        } else if (line.contains("ke")) {
            String p = line.replace("ke", "@");
            if (p.startsWith("@") && p.endsWith("yence")) {
                res = true;                
            }
        } else if (line.contains("k")) {
            String p = line.replace("k", "@");
            if (p.startsWith("@") && p.endsWith("eyence")) {
                res = true;                
            }
        }
        out.println(res ? "YES" : "NO");
        out.close();
    }
}
