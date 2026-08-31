import java.util.Scanner;

public class InitialBet478A {

	public static void main(String[] args) {
		Scanner kyb = new Scanner(System.in);
		int T[]= new int[5];
		int somme=0;
		for(int i=0;i<T.length;i++) {
			T[i]=kyb.nextInt();
			somme+=T[i];

		}
		if(somme%5==0 ) {
			if(somme==0) {
				System.out.println(-1);
			}
			else {
				System.out.println(somme/5);
			}
		}
		else {
			System.out.println(-1);
		}



	}

}
