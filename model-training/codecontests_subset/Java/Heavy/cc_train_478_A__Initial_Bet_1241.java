import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Code {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0;i<5;++i){
			sum+=Integer.parseInt(st.nextToken());			
		}
		if(sum%5==0 && sum!= 0){
			bw.append(sum/5 + "\n");
		}
		else{
			bw.append("-1\n");
		}		
		bw.flush();
	}
}
