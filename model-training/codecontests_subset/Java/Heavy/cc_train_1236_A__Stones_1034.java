import java.util.*;

public class Practice1{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
			int[] arr = new int[3];
			for(int i = 0; i < 3; i++){
				arr[i] = sc.nextInt();
			}
			int ans = max_stone(arr);
			System.out.println(ans);
		}
		
	}
	
	public static int max_stone(int[] arr){
		int a = arr[0];
		int b = arr[1];
		int c = arr[2];
		int count = 0;
		int cur = Math.min(2*b, c);
		if(cur % 2 != 0){
			cur -= 1;
		}
		b -= (cur/2);
		cur += (cur/2);
		int cur1 = Math.min(2 *a, b);
		if(cur1 % 2 != 0){
			cur1 -= 1;
		}
		cur1 += (cur1/2);
		count = cur1 + cur;
		return count;
	}

	}