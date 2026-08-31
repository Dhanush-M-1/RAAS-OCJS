import java.util.*;
public class Chess{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[]=new int[n];
		for (int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int one=1;
		int two=2;
		int three=3;
		int flag=0;
		for (int i=0;i<n;i++) {
			if(arr[i]==one || arr[i]==two){
				flag=0;
			}
			else{
				System.out.println("NO");
				return ;
			}
			if (arr[i]==one) {
				int temp=two;
				two=three;
				three=temp;
			}
			else if (arr[i]==two) {
				int temp=one;
				one=three;
				three=temp;
			}
		}
		System.out.println("YES");
	}
}