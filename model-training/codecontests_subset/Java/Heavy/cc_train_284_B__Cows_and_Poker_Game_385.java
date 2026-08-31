import java.util.*;
import java.io.*;

public class Main{

    BufferedReader in;
    StringTokenizer str = null;
    PrintWriter out;

    private String next() throws Exception{
    	if (str == null || !str.hasMoreElements())
    	    str = new StringTokenizer(in.readLine());
    	return str.nextToken();
    }
    
    private int nextInt() throws Exception{
	   return Integer.parseInt(next());
    }
    
    public void run() throws Exception{
    	in = new BufferedReader(new InputStreamReader(System.in));
    	out = new PrintWriter(System.out);

        int n = nextInt();
        char a[] = next().toCharArray();
        int is = 0;
        int as = 0;
        for(int i=0;i<n;i++){
            if (a[i] == 'I') is++;
            if (a[i] == 'A') as++;
        }	

        if (is == 1) {
            System.out.println(1);
        }else if (is > 1){
            System.out.println(0);
        }else{
            System.out.println(as);
        }
    }

    public static void main(String args[]) throws Exception{
	new Main().run();
    }
}