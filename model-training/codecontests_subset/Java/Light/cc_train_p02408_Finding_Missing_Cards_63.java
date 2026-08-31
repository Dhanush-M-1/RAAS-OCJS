import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
	public static void main(String[] args)throws Exception{
	
		ArrayList<String> list = new ArrayList<String>();
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++){
			list.add(br.readLine());
		}
		
		for(int i=1; i<=13; i++){
			if(list.contains("S " +i) == false){
				sb.append("S "+ i +"\n");
			}
		}
		
		for(int i=1; i<=13; i++){
			if(list.contains("H " +i) == false){
				sb.append("H "+ i +"\n");
			}
		}
		
		for(int i=1; i<=13; i++){
			if(list.contains("C " +i) == false){
				sb.append("C "+ i +"\n");
			}
		}
		
		for(int i=1; i<=13; i++){
			if(list.contains("D " +i) == false){
				sb.append("D "+ i +"\n");
			}
		}
		System.out.print(sb);
	}
}