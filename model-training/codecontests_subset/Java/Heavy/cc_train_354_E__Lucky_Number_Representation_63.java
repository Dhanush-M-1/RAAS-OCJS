import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class E {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
    class Choice{
    	int sum;
    	int carry;
    	int[] nums;
    	public Choice(int sum, int carry, int[] nums){
    		this.sum = sum;
    		this.carry = carry;
    		this.nums = new int[nums.length];
    		for(int i = 0; i < nums.length; i++)
    			this.nums[i] = nums[i];
    	}
    }
    
    ArrayList<Choice> choices = new ArrayList<Choice>();
    
	public void solve() throws IOException {				
		build(0, 0, new int[6]);
		int T = nextInt();
		for(int i = 0; i < T; i++){
			char[] ss = reader.readLine().toCharArray();
			int[] target = new int[ss.length];
			for(int j = 0; j < ss.length; j++){
				target[j] = Character.getNumericValue( ss[ss.length-j-1] );
			}
			
//			if(true) {
//				for(int j = 0; j < ss.length; j++){
//					out.println( target[j] );
//				}
//				continue;
//			}
			
			int[] ans = dfs(0, target, 0, new boolean[ss.length][10], new int[ss.length]);
			
			if(ans == null){
				out.println(-1);
			}
			else{
				long[] nums = new long[6];
				for(int j = 0; j < ss.length; j++){
					for(int k = 0; k < 6; k++){
						nums[k] += (long)Math.pow(10L, j) * choices.get(ans[j]).nums[k];
					}					
				}
				for(int j = 0; j < 6; j++){
					out.print( nums[j] + " " );
				}
				out.println();
				
//				out.println("COOL");
			}
		}
	
//		for(Choice choice: choices){
//			out.print( choice.sum + ", " + choice.carry+ ": " );
//			for(int i = 0; i < 6; i++){
//				out.print(choice.nums[i] + ", ");
//			}
//			out.println();
//		}
//		out.println( choices.size() );
	}
	
	public String printChoices(Choice choice){
		String str = "";
		for(int i = 0; i < 6; i++){
			str += (choice.nums[i] + " ");
		}
		return str;
	}
	
	public int[] dfs(int index, int[] target, int carry, boolean[][] transition, int[] ans){
		if( index == target.length ){
			if( carry == 0)
				return ans;
			else
				return null;
		}		
		int tar = (target[index] - carry + 10) % 10 ;
		for(int i = 0; i < choices.size(); i++){
			Choice choice = choices.get(i);
			
			if( choice.sum != tar) continue;
			
			int car = choice.carry + (choice.sum + carry >= 10? 1: 0);

			if(transition[index][car]) continue;
			
//			out.println( printChoices(choice) + " carry: " + car );
			
			transition[index][car] = true;
			ans[index] = i;
			
			int[] tans = dfs(index+1, target, car, transition, ans); 
			if(tans != null)
				return tans;
		}
		return null;
	}
	
	
	public void build(int index, int sum, int[] nums){
		if( index == 6){
			choices.add( new Choice(sum%10, sum/10, nums) );
			return;
		}
		nums[index] = 0;
		build(index+1, sum+0, nums);		
		nums[index] = 4;
		build(index+1, sum+4, nums);
		nums[index] = 7;
		build(index+1, sum+7, nums);
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new E().run();
	}
	
	public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
