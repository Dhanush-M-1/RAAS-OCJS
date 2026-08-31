import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] p=new int[n];
		for(int i = 0; i<n; i++){
			p[i]=sc.nextInt()-1;
		}
		int ans=0;
		for(int i = 0; i<n-1; i++){
			if(p[i]==i){
				p[i+1]=p[i];
				ans++;
			}
		}
		if(p[n-1]==n-1){
			ans++;
		}
		System.out.println(ans);
	}
}
