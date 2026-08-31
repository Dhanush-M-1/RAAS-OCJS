import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class Main {


    public static void main(String[] args) {

        File file = new File("in.txt");
        InputStream inputStream = null;
        // try {inputStream= new FileInputStream(file);} catch (FileNotFoundException ex){return;};
        inputStream = System.in;
        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, inputStream, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputStream in, PrintWriter out) {
            int pos = 1;
            int neg = 0;
            int res = -1;
            String line = null;
            BufferedReader buf = new BufferedReader(new InputStreamReader(in));
            try {
                line = buf.readLine();
            }
            catch (IOException e){
                out.print(e.getMessage());
                return;
            }


            String[] tokens = line.split(" ");
            res = Integer.parseInt(tokens[tokens.length-1]);
            Deque<String> signs = new LinkedList<>();
            signs.add("+");

            for(int i=1; i<tokens.length-2; i+=2){
                if(tokens[i].equals("+")){
                    pos++;
                    signs.addLast("+");
                }
                else if(tokens[i].equals("-")){
                    neg++;
                    signs.addLast("-");
                }

            }

            if (!isFeasible(pos,neg,res,res)){
                out.println("Impossible");
                return;
            }

            out.println("Possible");
            StringBuffer sb  = solveFor(pos,neg,res,res, signs);

            sb.append("= " + res);



            out.println(sb.subSequence(2,sb.length()));
        }

        public static StringBuffer solveFor(int plus, int minus, int result, int bound, Deque<String> signs){

            if(signs.isEmpty()){
                return new StringBuffer();
            }

            String sign = signs.pollFirst();

            boolean solFound =false;
            StringBuffer sb = new StringBuffer();




            int newPlus = -1;
            int newMinus = -1;
            int newResult = -1;
            int i = -1;

            if (sign.equals("+")) {
                i=1;
                while(!solFound && i <= bound) {

                    if (isFeasible(plus - 1, minus, result - i,bound)) {
                        newPlus = plus - 1;
                        newMinus = minus;
                        newResult = result - i;
                        solFound = true;
                    } else {
                        i++;
                    }
                }



            }

            else if (sign.equals("-")) {
                i=1;
                while(!solFound && i <= bound) {

                    if (isFeasible(plus, minus - 1, result + i,bound)) {
                        newPlus = plus;
                        newMinus = minus - 1;
                        newResult = result + i;
                        solFound = true;
                    } else {
                        i++;
                    }
                }
            }


            sb.append(sign + " " + i + " " + solveFor(newPlus,newMinus,newResult,bound, signs));

            return  sb;









        }

        public static boolean isFeasible(int plus, int minus, int result, int bound){
            int min = plus - bound * minus;
            int max = plus * bound - minus;
            if (min <= result && result <=max){
                return true;
            }
            return false;

        }
    }



    static class InputReader {
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

        public int nextInt() { return Integer.parseInt(next());}
        public long nextLong() { return Long.parseLong(next());}

    }
}