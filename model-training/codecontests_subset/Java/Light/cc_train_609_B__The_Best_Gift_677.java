import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,m,res=0,diff=0,add=0,add1;
		int[] arr;
		n=sc.nextInt();
		m=sc.nextInt();
		arr =new int[n];
		int[] count=new int[m+1];
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
			count[arr[i]]++;
		}
			for(int i=1;i<m+1;i++){
				for(int j=i+1;j<m+1;j++){
					add+=count[j];
				}
				res+=add*count[i];
				add=0;
			}
		System.out.println(res);
	}
}
