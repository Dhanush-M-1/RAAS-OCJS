import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Main{
    public static void main(String[] args)throws IOException{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int n = Integer.parseInt(br.readLine());
	String s[] = br.readLine().split(" ");
	int a = 0,b = 0, x = 0, c = 0 ,d = 0;
	for(int i = 0; i<n;i++){
	    x = Integer.parseInt(s[i]);
	    c = Math.abs(1000000-x);
	    d = Math.abs(1-x);
	    if(c>d){
		b = Math.max(d,b);
	    }else{
		a = Math.max(c,a);
	    }
	}
	out.println(Math.max(a,b));

     out.close();
    }
}
