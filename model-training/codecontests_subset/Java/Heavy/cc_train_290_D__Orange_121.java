import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Sunits789
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s=in.next();
        int d=in.nextInt();
        int l=s.length();
        char c[]=new char[l];
        for(int i=0;i<l;i++){
            if(s.charAt(i)<='Z'){
                c[i]= (char) (s.charAt(i)+(char)97-(char)65);
            }
            else {
                c[i]=s.charAt(i);
            }
            //System.out.println(c[i]);
            if(c[i]<(char) (d+97)){
                c[i]= (char) (c[i]-(char)97+(char)65);
            }
        }
        for(int i=0;i<l;i++){
            out.print(c[i]);
        }
    }
}

class InputReader{
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream){
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
    public String next(){
        while (tokenizer == null||!tokenizer.hasMoreTokens()){
            try{
                tokenizer = new StringTokenizer(reader.readLine());
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }

            catch (NullPointerException e){
                throw new UnknownError();
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt(){
        return Integer.parseInt(next());
    }

    }

