import java.util.Scanner;

public class Main {

	public static boolean check(double a){
		double b;
		b = Math.sqrt(a);
		if(b>1.0 && b<2.0) return true;

		for(int i=2;i<=(int)Math.floor(b);i++){
			if((a%2.0) == 0.0) return false;
			if((a%(double)i) == 0.0) return false;
		}
		return true;
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int i,c=0,n;
		double tmp;
		n = sc.nextInt();

		for(i=0;i<n;i++){
			tmp = sc.nextDouble();
			if(check(tmp)) c++;
			else continue;
		}
		System.out.println(c);
	}

}
