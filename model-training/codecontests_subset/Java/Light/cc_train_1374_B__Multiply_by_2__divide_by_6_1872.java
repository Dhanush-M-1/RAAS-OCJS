import java.util.Scanner;
public class mulitply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		int query=obj.nextInt();
		for(int i=0;i<query;i++) {
			int n=obj.nextInt();
			if(n==1) System.out.println(0);
			else if(n%3!=0) System.out.println(-1);
			else {
				int two=0;
				int three=0;
				while(n%3==0) {
					n/=3;
					three++;
				}
				while(n%2==0) {
					n/=2;
					two++;
				}
				if(n!=1) System.out.println(-1);
				else if(two>three) System.out.println(-1);
				else System.out.println(three+(three-two));
			}
		}

	}

}