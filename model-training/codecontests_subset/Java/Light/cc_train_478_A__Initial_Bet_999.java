import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class AInitialBet{
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		PrintWriter out = new PrintWriter(System.out);
		String [] endBets = br.readLine().split(" ");
		int sum=0;
		for(int i=0;i<endBets.length;i++)
			sum+=Integer.parseInt(endBets[i]);
		if(sum%5==0 && sum>0) 
			out.println(sum/5);
		else
			out.println("-1");
		out.flush();
	}
	
}
