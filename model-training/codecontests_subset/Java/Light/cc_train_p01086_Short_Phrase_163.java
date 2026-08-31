import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


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
			String words[] = new String[n];
			
			for(int i = 0; i < n; i++){
				words[i] = br.readLine();
			}
			
			System.out.println(solve(words));
		}
	}
	
	static int solve(String[] words){
		int n = words.length;
		
		int start = 0;
		
		int[] rules = {5,7,5,7,7};
		
		for(int i = 0; i < n; i++){
			int[] rulesCopy = Arrays.copyOf(rules, 5);
			int ruleIndex = 0;
			for(int j = i; j < n && ruleIndex < 5; j++){
				rulesCopy[ruleIndex] -= words[j].length();
				if(rulesCopy[ruleIndex] == 0){
					ruleIndex++;
				}
				else if(rulesCopy[ruleIndex] < 0){
					break;
				}
			}
			
			if(rulesCopy[4] == 0){
				start = i + 1;
				break;
			}
		}
		
		return start;
	}

}