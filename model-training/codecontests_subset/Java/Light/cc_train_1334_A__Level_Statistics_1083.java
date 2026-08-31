import java.util.Scanner;
public class S{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
			int n = in.nextInt();
			int[][] arr = new int[n][2];
			for(int j=0;j<n;j++){
				arr[j][0] = in.nextInt();
				arr[j][1] = in.nextInt();
			}
			int count = 0;
			for(int j=0;j<n-1;j++){
				if(arr[j+1][0]>arr[j][0] ){
					if(arr[j+1][1]>=arr[j][1] && (arr[j+1][0]-arr[j][0])>=(arr[j+1][1]-arr[j][1])){
						count++;
					}else{
						count--;
					}
				}else if(arr[j+1][0]==arr[j][0]){
					if(arr[j+1][1]==arr[j][1]){
						count++;
					}else{
						count--;
					}
				}else{
					count--;
				}
			}
			if(count==n-1 && arr[0][0]>=arr[0][1]){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}