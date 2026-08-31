import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int [] a=new int [3];
		int count=0;
		while(n>=1){
			for(int i=0;i<3;i++){
				a[i] =sc.nextInt();
			}
				while(a[1]>=1 && a[2]>=2){
					a[1]-=1;
					a[2]-=2;
					count+=3;
				}
				while(a[0]>=1 && a[1]>=2){
					a[0]-=1;
					a[1]-=2;
					count+=3;
				}
			n--;
			System.out.println(count);
			count=0;
		}
	}
}

			     				   	 				 									