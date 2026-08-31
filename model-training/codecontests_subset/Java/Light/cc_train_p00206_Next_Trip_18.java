import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		label:while(true){
			int N = cin.nextInt();
			if(N==0){
				break;
			}
			boolean f = false;
			for(int i =0;i<12;i++){
				int a = cin.nextInt();
				int b = cin.nextInt();
				N = N - (a-b);
				if(!f&&N<=0){
					System.out.println(i+1);
					f = true;
				}
			}
			if(!f)
			System.out.println("NA");
		}
		
	}
}