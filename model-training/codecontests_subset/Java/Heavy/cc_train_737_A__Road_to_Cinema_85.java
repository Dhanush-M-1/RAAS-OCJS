import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        File file = new File("in.txt");
        InputStream inputStream = null;
        // try {inputStream= new FileInputStream(file);} catch (FileNotFoundException ex){return;};
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
    Integer roadLength;
    Integer time;
    List<Integer> gasStations;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        Integer numberOfCars = in.nextInt();
        Integer numberOfGasStations = in.nextInt();
        roadLength = in.nextInt();
        time = in.nextInt();
        List<Integer> price = new ArrayList<>(numberOfCars);
        List<Integer> tankCapacity = new ArrayList<>(numberOfCars);
        gasStations = new ArrayList<>(numberOfGasStations+1);
        gasStations.add(0);
        for(int i=0; i<numberOfCars; i++){
            price.add(in.nextInt());
            tankCapacity.add(in.nextInt());
        }
        for(int i=0; i<numberOfGasStations; i++){
            gasStations.add(in.nextInt());
        }
        gasStations.add(roadLength);
        gasStations.sort(Integer::compareTo);


        List<Integer> tankCopy = new ArrayList<>(tankCapacity);
        tankCopy.sort(Integer::compareTo);

        Integer min = 0;
        Integer max = tankCopy.size()-1;
        Integer mid = null;

        if(!willReach(tankCopy.get(max))){
            out.println("-1");
            return;
        }
        while(min<max){
            mid = (min+max) / 2;
            if(willReach(tankCopy.get(mid))){
                max = mid;
            }
            else{
                min = mid+1;
            }
        }

        Integer capacityAtLeast = tankCopy.get(min);





        Integer minPrice = Integer.MAX_VALUE;
        for(int i=0; i<numberOfCars; i++){
            if(tankCapacity.get(i) >= capacityAtLeast){
                minPrice = Math.min(minPrice, price.get(i));
            }
        }
        if(minPrice == Integer.MAX_VALUE){
            out.println("-1");
        }
        else {
            out.println(minPrice);
        }


    }

    public boolean willReach(Integer tankCapacity){
        Integer timePassed = 0;
        for(int i=0; i<gasStations.size()-1; i++){
            Integer dist = gasStations.get(i+1) - gasStations.get(i);
            if(dist>tankCapacity){
                return Boolean.FALSE;
            }
            Integer timeOnFasterSpeed = Math.min(dist, (tankCapacity-dist));
            timePassed += timeOnFasterSpeed + Math.max((dist - timeOnFasterSpeed)*2,0);
        }
        if(timePassed > time){
            return Boolean.FALSE;
        }
        return Boolean.TRUE;


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