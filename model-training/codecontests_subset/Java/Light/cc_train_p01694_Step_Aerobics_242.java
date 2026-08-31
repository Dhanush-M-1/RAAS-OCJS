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

		while(true){
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0){
				break;
			}
			
			String[] tmpArray = br.readLine().split(" ");
			
			final int OFF = 0;
			final int ON = 1;
			int position = OFF;
			int right = OFF;
			int left = OFF;
			int count = 0;
			for(int i = 0; i < n; i++){
				String com = tmpArray[i];
				
				if(com.equals("lu")){
					left = ON;
				}
				if(com.equals("ld")){
					left = OFF;
				}
				if(com.equals("ru")){
					right = ON;
				}
				if(com.equals("rd")){
					right = OFF;
				}
				
				if(left == right && left != position){
					position = left;
					count++;
				}
			}
			
			System.out.println(count);
		}
	}

}