
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()) {
			int T=in.nextInt();
			while(T-->0) {
				int n=in.nextInt();
				int[] a=new int[n];
				
				for(int i=0;i<n;i++) {
					a[i]=in.nextInt();
				}
				int g=0,s=0,t=0,m=n/2;
				int max=a[0],max2=a[0];
				 if(n<10) {
						System.out.println("0 0 0");
						continue ;
				}
				else{
					for(int i=0;i<n/2;i++) {
						if(max==a[i]) {
							g++;
						}
						if(max!=a[i]) {
							max2=a[i];
							s=1;
							for(int j=i+1;j<n/2;j++) {
								if(max2==a[j]) {
									s++;
								}else {
									if(s<=g) {
										max2=a[j];
										s++;
									}else {
										break;
									}
								}
							}
							break;
						}
						
					}
					t=m-g-s;
				}
				for(int i=m-1;i>g+s;i--) {
					if(a[i]==a[m]) {
						t--;
					}else {
						break;
					}
				}
				if(g<s&&g<t) {
					System.out.println(g+" "+s+" "+t);
				}else {
					System.out.println("0 0 0");
				}
			}
	}
	}
}
