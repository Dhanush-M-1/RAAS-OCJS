import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		int tmp;
		int minj = 0;
		int count = 0;
		for(int i = 0;i<n;i++){
			list[i] = sc.nextInt();
		}
		for(int i = 0;i<n;i++){
			minj = i;
			for(int j = i;j<n;j++){
				if(list[j] < list[minj]){
					minj = j;
					
				}
			}
			if(list[i] != list[minj]){
				tmp = list[i];
				list[i] = list[minj];
				list[minj] = tmp;
				count += 1;
			}
			
		}
		for(int i = 0;i < n;i++){
			System.out.print(list[i]);
			if(i != (n-1)){
				System.out.print(" ");
			}else{
				System.out.println();
			}
		}
		System.out.println(count);
	
	}
}
