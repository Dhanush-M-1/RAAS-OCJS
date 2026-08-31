import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int n;
		int count=0;
		Scanner scan = new Scanner(System.in);
		n=scan.nextInt();
		for(int i=0;i<n;i++){
			if(PrimeNumber(scan.nextInt())){
				count++;
			}
		}
		scan.close();
		System.out.println(count);
	}
	public static Boolean PrimeNumber(int m){
		Boolean PN = true;
		for(int i=2;i*i<=m;i++){
			if(m%i==0){
				PN=false;
				break;
			}
		}
		return PN;
	}
}
