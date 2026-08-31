import java.util.*;
public class A433 {
	public static void main(String[] args){
		Scanner br = new Scanner(System.in);
		int n = br.nextInt();
		int[] nums = new int[n];
		int sum = 0;
		for(int i = 0;i<n;i++){
			nums[i] = br.nextInt();
			sum+=nums[i];
		}
		Arrays.sort(nums);
		int s1 = 0;
		int s2 = 0;
		if(sum%2 == 0){
			for(int j = n-1;j>=0;j--){
				if(s1 <= s2){
					s1+=nums[j];
				}
				else{
					s2+=nums[j];
				}
			}
			if(s1 == s2){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}
		else{
			System.out.println("NO");
		}
	}
}
