import java.util.*;
public class Main {
	
	private void doit(){
		Scanner sc =new Scanner(System.in);
		int da = sc.nextInt();
		while(da-- > 0){
			long n = sc.nextLong();
			int count = 0;
			long max = n;
			while(true){
				if(max < 10){
					System.out.println(count);
					break;
				}
				max = solve(max);
				if(max >= n){
					System.out.println(-1);
					break;
				}
				count++;
			}
		}
	}

	private int solve(Long num) {
		String n = "" + num;
		int max = 0;
		for(int i = 1 ; i <n.length(); i++){
			int left = Integer.parseInt(n.substring(0, i));
			int right = Integer.parseInt(n.substring(i));
			int res = left * right;
			max = Math.max(max, res);
		}
		return max;
	}

	public static void main(String[] args) {
		Main obj = new Main();
		obj.doit();
	}
}