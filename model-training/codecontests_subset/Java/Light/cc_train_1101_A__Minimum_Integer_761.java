import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n;
		do{
			n=sc.nextInt();
		}while(n<1 || n>500);
		int[] arr=new int[n];
		for(int i=0;i<n;i++){
			int l,r,d;
			do{
				l=sc.nextInt();
				r=sc.nextInt();
				d=sc.nextInt();
			}while(l<1 || l>r || r>10e9 || d<1 || d>10e9);
			arr[i]=solver(l,r,d);

		}

		for(int a:arr){
			System.out.println(a);
		}
	}

	public static int solver(int l,int r,int d){
		if(l>d){
			return d;
		}else if(r<d){
			return d;
		}else{
			return ((r/d)+1)*d;
		}
	}
}