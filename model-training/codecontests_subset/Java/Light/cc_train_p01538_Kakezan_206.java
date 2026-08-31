import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int q = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < q; i++){
			String input = br.readLine();
			System.out.println(solve(input));
		}
	}
	
	static int solve(String str){
		int times = 0;
		while(true){
			int len = str.length();
			
			//1???????????????????????????
			if(len == 1){
				return times;
			}
			
			int max = 0;
			for(int i = 1; i < len; i++){
				int a = Integer.parseInt(str.substring(0, i));
				int b = Integer.parseInt(str.substring(i, len));
				
				if(max < a*b){
					max = a*b;
				}
			}
			
			str = Integer.toString(max);
			times++;
		}
	}

}