import java.util.Map;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.Writer;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author monsterspy
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        Output out = new Output(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {
    public void solve(int testNumber, FastScanner s, Output ww) {
        try{
            String str = s.nextString();
            int len = str.length();
            int[] M = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            Map<String,Integer> mm = new HashMap<String,Integer>();
            String max = "";
            for(int i=0;i+10<=len;i++){
                if(str.charAt(i+2) != '-' || str.charAt(i+5) != '-') continue;
                else{
                    try {
                        int day = Integer.parseInt(str.substring(i, i + 2));
                        int mth = Integer.parseInt(str.substring(i + 3, i + 5));
                        int yr = Integer.parseInt(str.substring(i + 6, i + 10));

                        if (yr < 2013 || yr > 2015) continue;
                        if (mth < 1 || mth > 12) continue;
                        if (day < 1 || day > M[mth - 1]) continue;

                        String temp = str.substring(i, i + 10);

                        if (!mm.containsKey(temp)) mm.put(temp, 1);
                        else mm.put(temp, mm.get(temp) + 1);

                        if (!mm.containsKey(max) || mm.get(temp) > mm.get(max))
                            max = temp;
                    }catch(Exception e){

                    }
                }
            }
            ww.print(max);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

class FastScanner {
    BufferedReader s;
    StringTokenizer st;

    public FastScanner(InputStream InputStream){
        st = new StringTokenizer("");
        s = new BufferedReader(new InputStreamReader(InputStream));
    }

    public FastScanner(File f) throws FileNotFoundException{
        st = new StringTokenizer("");
        s = new BufferedReader (new FileReader(f));
    }

    public String nextString() throws IOException{
        if(st.hasMoreTokens())
            return st.nextToken();
        else{
            st = new StringTokenizer(s.readLine());
            return nextString();
        }

    }

}

class Output {

    private final PrintWriter writer;

    public Output(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public Output(Writer writer) {
        this.writer = new PrintWriter(writer);
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void close() {
        writer.close();
    }


}
