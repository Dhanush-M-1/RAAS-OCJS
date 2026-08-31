import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        File file = new File("in.txt");
        InputStream inputStream = null;
//        try {inputStream= new FileInputStream(file);} catch (FileNotFoundException ex){return;};
        inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}





class TaskB {

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Integer cities = in.nextInt();
        Integer paths = in.nextInt();

        Integer edgesReq = Math.max(cities-5,0) + 6;

        if((paths < edgesReq) || (cities <=4) ){
            out.println("-1");
            return;
        }


        Integer a = in.nextInt();
        Integer b = in.nextInt();
        Integer c = in.nextInt();
        Integer d = in.nextInt();

        Set<Integer> used = new HashSet<>();
        used.add(a);
        used.add(b);
        used.add(c);
        used.add(d);

        StringBuilder path = new StringBuilder();
        for(int i=1; i<=cities; i++){
            if(!used.contains(i)){
                path.append(i);
                path.append(" ");
            }
        }

        String pathStr = path.toString();

        out.println(a + " " + c + " " + pathStr + d +" "+ b);
        out.println(c + " " + a + " " + pathStr + b +" "+ d);











    }




}








class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public String nextLine(){
        try {
            return reader.readLine();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    public long nextLong() { return Long.parseLong(next()); }

}



class Pair<F, S> {
    public final F first;
    public final S second;




    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ')';
    }
}