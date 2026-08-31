import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class sszb {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String Line =  br.readLine();
	String [] input = Line.split(" ");
	int n =Integer.parseInt(input[0]);
	long k =Long.parseLong(input[1]);
	String array = br.readLine();
	String [] input2 = new String[n+1] ;
	StringTokenizer st = new StringTokenizer(array);
	for(int i = 1 ;i<=n;i++){
		input2[i]=st.nextToken();
		if(k<=i)
			break;
		k-=i;
		
		
	}
	System.out.println(input2[(int)k]);
}
}
