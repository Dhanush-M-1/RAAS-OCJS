import java.util.*;
public class Main{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0;i<n;i++){
			a[i] = sc.nextInt();
		}
		int me = 1;
		double fri = Math.pow(10,6);
		long sec = 0;
		int i = 0;
		int j = n-1;
		while(n>0){
			if(a[i]-me==sec){
				i++;
				n--;
			}
			if(fri-a[j]==sec){
				j--;
				n--;
			}
			sec++;
		}
		System.out.println(sec-1);
	}
}