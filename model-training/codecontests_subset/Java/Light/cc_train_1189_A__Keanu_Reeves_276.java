import java.util.Scanner;

//import TetraHedron.Scanner;


public class KeenuReaves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input =new Scanner(System.in);
		int n = input.nextInt();
		String s = input.next();
		int ones =0;
		int zeros = 0;
		for(int i=0; i<n;i++){
			if(s.charAt(i)=='0')zeros++;
			else
				ones++;
		}
		if(zeros!=ones){
		   System.out.println(1);
		   System.out.println(s);
		}
		else{
			System.out.println(2);
			System.out.println(s.charAt(0)+" "+s.substring(1));
		}
	}

}
