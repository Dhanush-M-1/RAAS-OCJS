import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PhoneNumber {

    public static void main(String[] args) throws NumberFormatException, IOException
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();

            List<Integer> cards = new ArrayList<>();
            String[] numbers = in.nextToken().split("");
            for (int i = 0; i < numbers.length; i++) {
                cards.add(Integer.parseInt(numbers[i]));
            }

            if (!cards.contains(8)) {
                System.out.println(0);
            } else {
                int totalNumbers = 0;
                while (cards.contains(8) && n >= 11){
                    cards.remove(new Integer(8));
                    n = n - 11;
                    totalNumbers++;
                }
                System.out.println(totalNumbers);
            }
        }
    }

    static class InputReader {

        BufferedReader in;
        StringTokenizer tok;

        public InputReader(InputStream stream){
            in = new BufferedReader(new InputStreamReader(stream), 32768);
            tok = null;
        }

        String nextToken()
        {
            String line = "";
            while(tok == null || !tok.hasMoreTokens()) {
                try {
                    if((line = in.readLine()) != null)
                        tok = new StringTokenizer(line);
                    else
                        return null;
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    return null;
                }
            }
            return tok.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(nextToken());
        }
        long nextLong()	{
            return Long.parseLong(nextToken());
        }
        double nextDouble()	{
            return Double.parseDouble(nextToken());
        }

    }

}