import java.io.*;
import java.util.Arrays;
public class Test
{
    public static void main(String[] args)  throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String in[] = br.readLine().trim().split(" ");
	    int a = Integer.parseInt(in[0]);
	    int b = Integer.parseInt(in[1]);
	    int c = Integer.parseInt(in[2]);

	    int  t = (int)Math.ceil(a*c*1.0/b);
	    System.out.print(t-c);
    }
}