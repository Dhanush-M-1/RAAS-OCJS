import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.InputStream;


public class A123 {
        public static void main(String[] args) {
                InputStream inputStream = System.in;
                OutputStream outputStream = System.out;
                InputReader in = new InputReader(inputStream);
                PrintWriter out = new PrintWriter(outputStream);
                CodeA123 solver = new CodeA123();
                solver.solve(1, in, out);
                out.close();
        }
}

class CodeA123
{
public void solve(int testNumber, InputReader in, PrintWriter out)
{
	int d=in.nextInt();
	int s=in.nextInt();
	int t=in.nextInt();
	int D=d*t;
	int T=0;
	if(D%s==0)
	{
		T=D/s;
	}
	else
	{
		T=D/s+1;
	}
	out.println(T-t);
}

}






class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
	public void inputShuffleArrayInt(int arr[])
	{
		int l=arr.length;
		for(int i=0;i<l;i++)
		{
			if(i%2==0)
			{
				arr[i/2]=nextInt();
			}
			else
			{
				arr[l-((i+1)/2)]=nextInt();
			}
		}
	}

    }