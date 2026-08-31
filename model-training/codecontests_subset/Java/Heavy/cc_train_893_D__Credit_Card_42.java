import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int j=scanner.nextInt();
		int k=scanner.nextInt();
		int count=0;
		int countt=0;
		int minval=0;
		int maxval=0;
		int a[]=new int[j];
		for(int i=0;i<j;i++) {
			a[i]=scanner.nextInt();
		}
		for(int i=0;i<j;i++) {
			if(a[i]==0) {
				if(minval<0) {
					minval=0;
				}
				if(maxval<0) {
					maxval=k;
					count++;
				}
			}else {
				minval=minval+a[i];
				maxval=maxval+a[i];
				if(maxval>k) {
					maxval=k;
				}
				if(minval>k) {
					countt=1;
					System.out.println(-1);
					break;
				}
			}
		}
		if(countt==0) {
			System.out.println(count);
		}

	}

}