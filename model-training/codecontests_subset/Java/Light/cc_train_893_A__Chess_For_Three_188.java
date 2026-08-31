import java.util.*;

public class ChessForThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++){
			ar[i]=scan.nextInt();
		}
		boolean c=true;
		if(ar[0]==3) System.out.println("NO");
		else{
			int cp1 = 1, cp2 = 2, s=3;// 2 3 1
			for(int i=0; i<n; i++){
				if(ar[i]==cp1){
					int t=cp2;
					cp2=s;
					s=t;
				}else if(ar[i]==cp2){
					int t=cp1;
					cp1=s;
					s=t;
				}else{
					c=false;
				}
			}
			System.out.println(c?"YES":"NO");
		}
	}
}
