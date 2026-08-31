import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class c{
    public static void main(String[] args)throws IOException{
	br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int n = nextInt();
	String s = next(), p1 = "",p2 = "";
	if(n%2!=0){
	    out.println(1);
	    out.println(s);
	}else{
	    int co = 0;
	    p1 = ""+s.charAt(0);
	    for(int i = 0; i<n;i++){
		if(s.charAt(i)=='1'){
		    co++;
		}
		p2+= i!=0?""+s.charAt(i):"";
	    }
	    if(co==(n/2)){
		out.println(2);
		out.println(p1+" "+p2);
	    }else{
		out.println(1);
		out.println(s);
	    }
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
}
