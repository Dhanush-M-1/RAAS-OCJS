import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Long l = Long.parseLong(st.nextToken());
		Long r = Long.parseLong(st.nextToken());
		if(l.equals(r)){
			System.out.println(l);
		}
		else if(l % 3 == 0 && r % 3 == 0 && Math.floor((l-r)/3) == Math.floor((l-3)/2)){
			System.out.println(3);
		}else{
			System.out.println(2);
		}
		
	}

}
