import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		PrintWriter out=new PrintWriter(System.out);
		int N=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int rates[]=new int[N];
		for (int i=0;i<N ;i++ ) {
			rates[i]=Integer.parseInt(st.nextToken());
		}
		int diff=rates[0]-rates[1];
		for (int i=1;i<N-1 ;i++ ) {
			int temp=rates[i]-rates[i+1];
			if(temp>diff)
				diff=temp;
		}
		diff=diff-C;
		if(diff>0)
			out.println(diff);
		else
			out.println(0);
		out.close();
	}
}