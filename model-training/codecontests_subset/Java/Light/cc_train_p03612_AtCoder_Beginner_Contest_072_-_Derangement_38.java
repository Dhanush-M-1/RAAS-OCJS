import java.util.*;
public class Main {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] x=new int[n];
		for(int i=0;i<n;i++){
			x[i]=sc.nextInt();
		}
		int sum=0;
		for(int i=0;i<n-1;i++){
			if(i+1==x[i]){
				int tmp;
				tmp=x[i];
				x[i]=x[i+1];
				x[i+1]=tmp;
				sum++;
			}
		}
		if(x[n-1]==n){
			sum++;
		}
		System.out.print(sum);
		
	}
}
