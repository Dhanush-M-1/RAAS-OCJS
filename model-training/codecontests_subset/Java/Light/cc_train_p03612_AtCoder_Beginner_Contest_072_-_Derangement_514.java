import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int arr[] = new int [n+1]; 
		boolean flag = false;
		for(int i=1 ; i <= n ; i++){
			arr[i] = scanner.nextInt();
		}
		int count = 0;
		int i = 1;
		
		while(flag == false){
			if(i == n+1){
				i=1;
			}
			if(arr[i] == i){
				if(i!=n){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					i++;
					count ++;
				}else{
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
					i++;
					count ++;
				}
			}else{
				i++;
			}
			
			if(i == n+1){
				for(int j=1 ; j<=n ; j++){
					if(arr[j] == j){
						break;
					}
					if(j == n) flag = true;
				}
			}
		}
		
		System.out.println();
		System.out.println(count);
		
	}
}
