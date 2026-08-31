import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A1236 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		while (testcases-->0) {
			String[] line = new String[3];
			int[] nums = new int[3];
			int count = 0;
			
			line = br.readLine().split(" ");
			for(int i = 0; i<3;i++) {
				nums[i] = Integer.parseInt(line[i]);
			}
			
			
			int min = Math.min(nums[2]/2, nums[1]);
			nums[1] -= min;
			nums[2] -= min*2;
			count+= 3*min;
			
			min = Math.min(nums[1]/2, nums[0]);
			count+= 3*min;
			
			System.out.println(count);
			
					
					
		}
		
	}

}
