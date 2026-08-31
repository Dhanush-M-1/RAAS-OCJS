import java.util.Scanner;


public class CowsandPokergame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String s = input.next();
		 int F = 0;
		 int I = 0;
		 int A = 0;
		 for(int i=0;i<n;i++){
			 if(s.charAt(i)=='A')A++;
			 else if(s.charAt(i)=='F')F++;
			 else I++;
		 }
		 if(I==0){
			 System.out.println(A);
		 }
		 else if(I==1)
			 System.out.println(1);
		 else
			 System.out.println(0);
	}

}
