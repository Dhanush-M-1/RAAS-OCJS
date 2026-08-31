import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;
     
public class Main{
    public static void main(String[] args)throws IOException{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter out = new PrintWriter(System.out);
    	int n = nextInt();
    	while(n-->0){
    	    int a = nextInt();
    	    int b = nextInt();
	    int c = nextInt();
	    int ans = 0;
	    int aux = Math.min(c/2,b);
	    b-=aux;
	    c-=aux*2;
	    ans+=aux +aux*2;
	    aux = Math.min(b/2,a);
	    a-=aux;
	    b-=aux*2;
	    ans += aux+aux*2;
	    out.println(ans);
	}
	out.close();
    }
     
    static BufferedReader br;
    static StringTokenizer st = new StringTokenizer("");
    static String next()throws IOException{
    	while(!st.hasMoreTokens()){
    	    st = new StringTokenizer(br.readLine());
    	}
    	return st.nextToken();
    }
    static int nextInt()throws IOException{
    	return Integer.parseInt(next());
    }
    static long nextLong()throws IOException{
    	return Long.parseLong(next());
    }
}
