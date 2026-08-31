public class GuestGames{
	public static void main(String []args){
		
		java.util.Scanner scan=new java.util.Scanner(System.in);
		int n=scan.nextInt();
		int [][]arr=new int[n][2];
		for(int i=1;i<=arr.length;i++){
			for(int j=1;j<=2;j++){
				arr[i-1][j-1]=scan.nextInt();
			}
		}
		int count=0,home,guest;
		for(int i=1;i<=arr.length;i++){
			home=arr[i-1][0];
			for(int j=1;j<=arr.length;j++){
				guest=arr[j-1][1];
				if(j!=i){
					if(home==guest){
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}