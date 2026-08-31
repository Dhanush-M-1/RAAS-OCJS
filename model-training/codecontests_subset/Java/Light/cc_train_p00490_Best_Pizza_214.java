import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
	int N = sc.nextInt();
	int A = sc.nextInt();
	int B = sc.nextInt();
	int C = sc.nextInt();
	int[] Di = new int[N];
	
	for(int i=0;i < N;i++){
		Di[i] = sc.nextInt();
	}
	
	Arrays.sort(Di);
	int pc = C;
	int pp = A;
	
	for(int i=N-1;i > -1; i--){
		if(pc / pp <= (pc + Di[i]) / (pp + B)){
			pc = pc + Di[i];
			pp = pp + B;
		}
	}
	System.out.println(pc/pp);
}
}