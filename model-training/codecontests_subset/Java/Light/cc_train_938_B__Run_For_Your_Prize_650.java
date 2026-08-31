import java.util.Arrays;
import java.util.Scanner;


public class water {
	public static Scanner cin = new Scanner(System.in);
	
	public static void main(String[] args) {
		while(cin.hasNext()) {
			int n=cin.nextInt();
			boolean[] ptn=new boolean[1000001];
			for(int i=0;i<n;i++){
				ptn[cin.nextInt()]=true;
			}
			int res=0;
			int count=0;
			for(int i=2,j=1000000-1;count!=n;i++,j--){
				if(ptn[i]){
					count++;
				}
				if(ptn[j]){
					count++;
				}
				res++;
			}
			System.out.println(res);
		}
	}
}