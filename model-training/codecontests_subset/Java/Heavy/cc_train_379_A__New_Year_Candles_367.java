
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;

public class NewYrCandle_379A {
public static void main(String args[]) throws IOException{
	BufferedReader sIn=new BufferedReader(new InputStreamReader(System.in));
	PrintStream sOut=new PrintStream(System.out);
	StringTokenizer st=new StringTokenizer(sIn.readLine()," ");
	int n=Integer.parseInt(st.nextToken());
	int x=Integer.parseInt(st.nextToken());
	int sum=0;
	int nR=0;
	while(true){
		if(n==0&&nR==0)
			break;
		sum+=(n-n%x);
		nR+=n%x;
		
		if(nR>=x){
			sum+=x;
			nR=nR-x+1;
		}
		
		if(n==0){
			sum+=nR;
			nR=0;
		}
		
		n=n/x;
		
		//sOut.println(nR);
		//sOut.println(sum);
	}
	sOut.println(sum);
	sOut.close();
}
}
