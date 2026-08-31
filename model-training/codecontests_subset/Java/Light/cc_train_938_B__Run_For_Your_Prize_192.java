import java.util.Scanner;


public class RunForYourPrize {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int ar[] = new int[n];
			for(int i=0;i<n;i++){
				ar[i]= sc.nextInt();
			}
			int myCurrent=1;
			int friendCurrent = 1000000;
			int movesMy=0;
			int movesFriend=0;
			for(int j=0;j<n;j++){
				if(ar[j]<1000002/2){
					movesMy+=(ar[j]-myCurrent);
					myCurrent=ar[j];
				}
				else{
					movesFriend+=(friendCurrent-ar[j]);
					break;
				}
						
			}
			sc.close();
			System.out.println(Math.max(movesMy, movesFriend));
		}
}
