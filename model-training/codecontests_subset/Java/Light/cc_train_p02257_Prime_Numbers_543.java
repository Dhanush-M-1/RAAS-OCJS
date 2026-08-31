import java.util.Scanner;
class Prime{
	double x;
	Prime(int X){
		x=X;
	}
	boolean isPrime() {
		if(x==2) {
			return true;
		}
		else if(x<2||x%2==0) {
			return false;
		}
		else {
			int i=3;
			while(i<=Math.sqrt(x)) {
				if(x%i==0) {
					return false;
				}
				i=i+2;
			}
		}
		return true;
	}
}
public class Main{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Prime [] p=new Prime [n];
		int sum=0;
		for(int i=0;i<n;i++) {
			p[i]=new Prime(sc.nextInt());
			p[i].isPrime();
			if(p[i].isPrime()==true) {
				sum+=1;
			}
		}
		System.out.println(sum);
		sc.close();
	}
}

