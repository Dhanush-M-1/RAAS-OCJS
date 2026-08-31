import java.util.Scanner;


public class ChessForThree {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i =0;i<n;i++){
			a[i]=sc.nextInt();
		}
		
		int spictator = 3;
		int jo1 = 1;
		int jo2 = 2;
		int count = 0;
		int aux = 0 ;
		
		for(int i=0;i<n;i++){
			if(a[i] == jo1){
				aux = jo2;
				jo2 = spictator;
				spictator = aux;
			}else if(a[i] == jo2){
				aux = jo1;
				jo1 = spictator;
				spictator = aux;
			}
			else{
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		System.out.println("YES");
		
	}

}
