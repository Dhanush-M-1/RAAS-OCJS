import java.io.*;
import java.util.*;

public class TaskB {

    PrintWriter out;
    BufferedReader in;
    StringTokenizer tok = new StringTokenizer("");

    void solve() throws Exception {
        int n = readInt();
        String inp = readLine();

        HashMap<String, Integer> counter = new HashMap<>();

        for(int i = 0; i < n-1; ++i) {
            counter.put(inp.substring(i,i+2),counter.containsKey(inp.substring(i,i+2))?
                counter.get(inp.substring(i,i+2))+1:
                1
            );
        }

        Set<String> keys = counter.keySet();

        Object[] elems = keys.toArray();

        Arrays.sort(elems, (x,y) -> -counter.get(x.toString()).compareTo(counter.get(y.toString())));

        System.out.println(elems[0].toString());
    }

    void init() throws IOException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (IOException e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
    }

    public static void main(String[] args) {
        new TaskB().run();
    }

    String readLine(){
        try{
            return in.readLine();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    String delim = " ";

    String readString() {
        while(!tok.hasMoreTokens()) {
            String nextLine = readLine();
            if (nextLine == null) return null;

            tok = new StringTokenizer(nextLine, delim);
        }

        return tok.nextToken(delim);
    }

    int readInt(){ return Integer.parseInt(readString()); }

    long readLong() { return Long.parseLong(readString()); }

    void run(){
        try {
            init();
            solve();
            out.close();
        } catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }
}


