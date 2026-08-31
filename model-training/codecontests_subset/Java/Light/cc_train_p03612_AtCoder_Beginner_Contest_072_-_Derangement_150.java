import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] a=new int[n];
		int count=0;
		for(int i = 0; i<n; i++){
			a[i]= sc.nextInt();
		}
		for(int i = 0; i<n-1; i++){
			if(a[i]==i+1){
				if(a[i+1]==i+2){
					count++;
					a[i+1]=a[i];
				}else{
					count++;
				}
			}
		}
		if(a[n-1]==n){
			count++;
		}
		System.out.println(count);
	}
}