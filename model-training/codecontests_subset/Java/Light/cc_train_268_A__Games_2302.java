import java.util.Scanner;


public class Games {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		int count = 0;
		
		int[][] a = new int[n][2];
		
		for(int i=0; i<n; i++){
			for(int j=0; j<2; j++){
				a[i][j] = input.nextInt();
			}
		}
		
		for(int i=0; i<n; i++){
			for(int x=i; x<n; x++){
				for(int j=0; j<2; j++){
					if(j==0){
						if(a[i][j]==a[x][1]){
							count++;
						}
					}
					if(j==1){
						if(a[i][j]==a[x][0]){
							count++;
						}
					}
				}
			}
		}
		
		System.out.println(count);

	}

}
