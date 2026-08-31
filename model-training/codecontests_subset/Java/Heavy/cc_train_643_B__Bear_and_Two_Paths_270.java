import java.util.ArrayList;
import java.util.Scanner;

public class BearandTwoPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner (System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int a = input.nextInt();
		int b =input.nextInt();
		int c = input.nextInt();
		int d = input.nextInt();
		if(k<n+1|| n==4  ){
			System.out.println(-1);
			return;
		}
		System.out.print(a +" "+c+" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=n;i++){
			if(i!=a && i!=c && i!=d && i!=b){System.out.print(i+" ");list.add(i);}
			
			}
		System.out.println(d+" "+b);
		System.out.print(c+" "+ a+" ");
		for(int i=0; i<list.size();i++){
			System.out.print(list.get(i)+" ");
		}
		System.out.println(b+" "+d);
		//System.out.print(a);
	}

}
