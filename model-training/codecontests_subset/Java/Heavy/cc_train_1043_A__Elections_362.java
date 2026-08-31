import java.util.Scanner;

public class Main {
	public static int make(int a[]) {
		int sum2=0;
		int ma = 0;
		for(int i=0;i<a.length;i++) {
			sum2+=a[i];
			ma = Math.max(a[i], ma);
		}
	//	boolean t=true;
		int k= ma;
		int sum=0;
		while(true) {
		
			sum = 0;
			for(int i=0;i<a.length;i++) {
				sum+=k-a[i];
			}
			if(sum>sum2) {			
			    break;
			}
			else {
				k++;
			}
		}
		return k;
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()) {
			int num=in.nextInt();
			int a[]=new int[num];
			//System.out.println(a.length + "QAQ");
			for(int i=0;i<a.length;i++) {
				a[i]=in.nextInt();
			}
			System.out.println(make(a));
		}
	}
}