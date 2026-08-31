import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		int d=scanner.nextInt();
		int count=0;
		int count1=0;
		int minval=0;
		int maxval=0;
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=scanner.nextInt();
		}
		for(int i=0;i<n;i++) {
			if(a[i]==0) {
				if(minval<0) {
					minval=0;
				}
				if(maxval<0) {
					maxval=d;
					count++;
				}
			}else {
				minval=minval+a[i];
				maxval=maxval+a[i];
				if(maxval>d) {
					maxval=d;
				}
				if(minval>d) {
					count1=1;
					System.out.println(-1);
					break;
				}
			}
		}
		if(count1==0) {
			System.out.println(count);
		}

	}

}

 		  			  			   	    	   		  		