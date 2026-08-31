import java.util.Scanner;


public class Main {
	static Scanner sc = new Scanner(System.in);
	static int L;
	static int M[] = new int[12];
	static int N[] = new int[12];
	
	//main
	public static void main(String[] args) {
		while(read()){
			solve();
		}
	}
	
	//read
	static boolean read(){
		if(sc.hasNextInt()){
			if((L = sc.nextInt()) == 0) return false;
		}
		
		for(int i=0; i<12; i++){
			M[i] = sc.nextInt();
			N[i] = sc.nextInt();
		}
		return true;
	}
	
	//solve
	static void solve(){
		
		for(int i=0; i<12; i++){
			L -= M[i] - N[i];
			if(L <= 0){
				System.out.println(i+1);
				return;
			}
		}
		
		System.out.println("NA");
	}
}