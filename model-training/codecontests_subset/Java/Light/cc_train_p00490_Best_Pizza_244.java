import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		int topping_num = stdIn.nextInt();
		int material_value = stdIn.nextInt();
		int topping_value = stdIn.nextInt();
		int material_calorie = stdIn.nextInt(); //初期値として生地の値段を与える
		
		int[] data = new int[topping_num];
		int[] sum = new int[topping_num + 1];
		
		for(int r = 0; r < data.length; r++)
			data[r] = stdIn.nextInt();
		Arrays.sort(data); //後で修正
		for(int r = 0; r < data.length; r++) {
			sum[r + 1] = (sum[r] + data[r]);
		}
		int ans = -1;
		for(int r = sum.length - 1; r > 0; r--) {
			for(int c = 1; c < r; c++) {
				int psum = (sum[r] - sum[c] + material_calorie) / (material_value + topping_value*(r - c));
				if(psum > ans) {
					ans = psum;
				}
			}
		}
		
		
		System.out.println(ans);
		
	}

}