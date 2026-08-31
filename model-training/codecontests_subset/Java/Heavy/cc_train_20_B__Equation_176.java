import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.util.Arrays;

public class a{

    public static void main(String[] args)throws IOException{
    	br = new BufferedReader(new InputStreamReader(System.in));
    	PrintWriter out = new PrintWriter(System.out);
	int a = nextInt();
	int b = nextInt();
	int c = nextInt();
	double d = (double)b*b-4.0*a*c;
	if(a!=0){
	    if(d==0){
		out.println(1);
		double ans = (double)(b*-1)/(double)(2.0*a);
		out.printf("%.7f",ans);
	    }else if(d<0){
		out.println(0);
	    }else{
		out.println(2);
		d = Math.sqrt(d);
		double gl = b*-1.0;
		double ans1 = (gl-d)/(2.0*a);
		double ans2 = (gl+d)/(2.0*a);
		double a1 = Math.max(ans1,ans2);
		double b1 = Math.min(ans1,ans2);
		out.printf("%.7f\n",b1);
		out.printf("%.7f",a1);

	    }
	    
	}else if(b!=0){
	    out.println(1);
	    double ans = (double)c*-1.0/(double)b;
	    out.printf("%.7f\n",ans);
	}else if(c==0){
	    out.println(-1);
	}else{
	    out.println(0);
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
