import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;

import static java.lang.Math.ceil;

public class Main {
    public static void main(String[] args) {

        File file = new File("in.txt");
        File fileOut = new File("out.txt");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        // try {inputStream= new FileInputStream(file);} catch (FileNotFoundException ex){return;};
//        try {outputStream= new FileOutputStream(fileOut);} catch (FileNotFoundException ex){return;};
        inputStream = System.in;
        outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }


}

class Task {


    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Integer n = in.nextInt();
        Integer m = in.nextInt();
        Set<Integer> unvisited = new TreeSet<>();
        Set<Integer>[] e = new TreeSet[n];

        for(int i=0; i<n; i++){
            unvisited.add(i);
            e[i] = new TreeSet<>();
        }


        for(int i=0; i<m; i++){
            Integer n1 = in.nextInt()-1;
            Integer n2 = in.nextInt()-1;
            e[n1].add(n2);
            e[n2].add(n1);
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(unvisited.contains(i)){
                Integer size = visit(i, unvisited, e);
                result.add(size);
            }
        }
        result.sort(Comparator.naturalOrder());
        out.println(result.size());
        for(Integer val : result){
            out.print(val + " ");
        }


    }


    public Integer visit(Integer k, Set<Integer> unvisited, Set<Integer>[] e){
        Integer size = 1;
        unvisited.remove(k);
        Deque<Integer> st = new ArrayDeque<>();
        st.addFirst(k);

        while(st.size()>0){
            Integer n = st.removeFirst();
            Set<Integer> toRemove = new TreeSet<>();
            Set<Integer> noEdge = e[n];

            for(int i : unvisited){
                if(!noEdge.contains(i)){
                    toRemove.add(i);
                    size++;
                    st.addFirst(i);
                }
            }
            for(int l : toRemove){
                unvisited.remove(l);
            }
        }
        return size;
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

class IntPair extends Pair<Integer, Integer>{
    public IntPair(Integer first, Integer second){
        super(first, second);
    }
}

class LPair extends Pair<Long, Long>{
    public LPair(Long first, Long second){
        super(first, second);
    }
}
