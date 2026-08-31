import java.util.Scanner;

public class Main{

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);
		int i,n,num,count=0;
		n=scan.nextInt();
		for(i=0;i<n;i++) {
			num=scan.nextInt();
			count+=checkpm(num);
		}
		System.out.println(count);
		scan.close();
	}
	public static int checkem(int num) {
		return num%2;
	}
	public static int checkpm(int num) {
		int i,ans;
		double root;
		if(num==2) {
			return 1;
		}
		ans=checkem(num);
		if(ans==0) {
			return 0;
		}
		else {
			root=Math.sqrt(num);
			for(i=3;i<=root;i+=2) {
				if(num%i==0) {
					return 0;
				}
			}
		}
		return 1;
	}
}
