import java.util.Scanner;


public class Barktounlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		String s = input.next();
		int n  = input.nextInt();
		String[] z = new String[n];
		boolean condition  = false;
		for(int i=0; i<n;i++){z[i] = input.next();
		if(s.equals(z[i])){
		    condition = true;
		}
		
		}
		if(condition){
			System.out.println("YES");
			return ;
		}
		boolean condition1 = false;
		boolean condition2 = false;
		for(int i=0; i<n;i++){
			if(s.charAt(0)==z[i].charAt(1)){
				condition1 = true;
				break;
			}
		}
		for(int i=0; i<n;i++){
			if(s.charAt(1)==z[i].charAt(0)){
				condition2 = true;
				break;
			}
		}
		if(condition1 && condition2){
			System.out.println("YES");
			
		}
		else{
			System.out.println("NO");
		}
		
				
		
	}

}
