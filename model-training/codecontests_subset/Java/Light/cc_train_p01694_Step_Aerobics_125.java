import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args)throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(isr);
		Main app = new Main();
		String str, s[];
		
		int n, res;
		while(!(str = reader.readLine()).equals("0")){
			n = Integer.valueOf(str);
			
			s = reader.readLine().split(" ");
			res = 0;
			for(int i = 1; i < n; i += 2){
				res += app.check(s[i], s[i - 1]);
			}
			System.out.println(res);
		}
		reader.close();
	}
	public int check(String x, String y){
		char l[] = x.toCharArray();
		char r[] = y.toCharArray();
		
		if(l[0] == r[0]){
			return 0;
		}else return 1;
	}
}