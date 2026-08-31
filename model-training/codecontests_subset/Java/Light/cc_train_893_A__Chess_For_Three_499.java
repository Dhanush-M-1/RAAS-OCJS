import java.util.Scanner;

public class ThreeChess {
    public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
		int n;
		boolean flag = false;
		n = sc.nextInt();
		
		int winner[] = new int[n];
		for(int i=0; i<n; i++){
			winner[i] = sc.nextInt();
		}
		
		int spec=3;
		int los;
		for(int i=0; i<n; i++){
			if(spec == winner[i]){
				System.out.println("No");
				System.exit(0);
			}
			
			los=6-winner[i]-spec;
			spec=los;
			
		}
		System.out.println("Yes");
	}

}
