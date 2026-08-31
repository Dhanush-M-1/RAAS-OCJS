import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		boolean[][] open = new boolean[n][10];
		for(int i = 0; i < n; i++){
			String[] tmpArray = br.readLine().split(" ");
			for(int j = 0; j < 10; j++){
				if(tmpArray[j].equals("1")){
					open[i][j] = true;
				}
			}
		}
		
		
		int[][] profits = new int[n][11];
		
		for(int i = 0; i < n; i++){
			String[] tmpArray = br.readLine().split(" ");
			for(int j = 0; j < 10; j++){
				profits[i][j] = Integer.parseInt(tmpArray[j]);
			}
		}
		
		//ありえるのは1023通り
		int max = Integer.MIN_VALUE;
		for(int i = 0b1; i <= 0b11_1111_1111 ; i++){
//			System.out.println(i);
			
			int tmpProfit = 0;
			//店ごとにチェック
			for(int j = 0; j < n; j++){
				int sameTime = 0;
				int tmp = i;
				for(int k = 0; k < 10; k++){
					if(open[j][k] && tmp % 2 == 1){
						sameTime++;
					}
					tmp /= 2;
				}
				
				tmpProfit += profits[j][sameTime];
			}
			
			if(max < tmpProfit){
				max = tmpProfit;
			}
		}
		
		System.out.println(max);
	}

}
