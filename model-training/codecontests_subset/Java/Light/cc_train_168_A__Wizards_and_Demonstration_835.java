import java.util.*;
import java.io.*;
public class demon
{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		String f[]=br.readLine().split(" ");
		int n=Integer.parseInt(f[0]);
		int w=Integer.parseInt(f[1]);
		int p=Integer.parseInt(f[2]);
		int need=(int)Math.ceil((double)n*p/100);
		need-=w;
		if(need>0)
		pw.println(need);
	    else
	    	pw.println(0);
		pw.flush();
	}
}