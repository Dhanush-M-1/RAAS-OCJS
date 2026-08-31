import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
}



class Task {

    List<Boolean> order = new ArrayList<>();

    public void solve(InputReader in, OutputWriter out) {
        Scanner scanner  = new Scanner(System.in);
        String line = scanner.nextLine();
        int questions = 0;
        int i = 0;
        order.add(true);
        while(true) {
            if(line.charAt(i) == '-') {
                order.add(false);
            } else if(line.charAt(i) == '+') {
                order.add(true);
            }
            else if(line.charAt(i) == '?') questions++;
            else if(line.charAt(i) == '=') break;
            i++;
        }

        Map<Integer, String> map = new HashMap<>();


        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            
        }
        
        i+=2;
        int number = Integer.parseInt(line.substring(i));
        int numbers[] = new int[questions];
        int m = 0;
        for(int j=0;j<numbers.length;j++) {
            if(order.get(j)) {
                numbers[j] = 1;
                m++;
            } else {
                numbers[j] = -1;
                m--;
            }
        }
        if(m >= number) {
            for(int j=0;j<numbers.length;j++) {
                if(!order.get(j)) {
                    int p = Math.min(m - number, number - 1);
                    numbers[j] -= p;
                    m -= p;
                }
            }
        } else {
            for(int j=0;j<numbers.length;j++) {
                if(order.get(j)) {
                    int p = Math.min(number - m, number - 1);
                    numbers[j] += p;
                    m += p;
                }
            }
        }

        if(m != number) {
            out.printLine("Impossible");
        } else {
            out.printLine("Possible");
            out.print(numbers[0]);
            for(int j=1;j<numbers.length;j++) {
                if(order.get(j)) {
                    out.print(" + " + numbers[j]);
                } else {
                    out.print(" - " + Math.abs(numbers[j]));
                }
            }
            out.print(" = " + number);
        }

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
    public boolean hasNext() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                String line = reader.readLine();
                if ( line == null ) {
                    return false;
                }
                tokenizer = new StringTokenizer(line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return true;
    }
    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() { return Double.parseDouble(next());}
}
class OutputWriter {
    private final PrintWriter writer;
    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }
    public OutputWriter(Writer writer) {
        this.writer = new PrintWriter(writer);
    }
    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if ( i != 0 ) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }
    public void printLine(Object... objects) {
        print(objects);
        writer.println();
    }
    public void close() {
        writer.close();
    }
}