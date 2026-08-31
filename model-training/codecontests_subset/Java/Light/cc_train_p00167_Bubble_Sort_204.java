
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n,count,a[];
		while(true){
			n=sc.nextInt();
			if(n==0) break;
			count=0;
			a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			for(int i=n;0<i;i--){
				for(int j=0;j+1<i;j++){
					if(a[j+1]<a[j]){
						int temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}