
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		long n,k,prev,pos;
		int i;
		n=sc.nextLong();
		k=sc.nextLong();
		int[]inp=new int[(int)n]; 
		for(i=0;i<n;i++){
			inp[i]=sc.nextInt();
		}
		prev=soln(k);
		pos=k-prev*(prev+1)/2;
		if(pos==0) pos=prev;
		System.out.println(inp[(int)(pos-1)]);
	}
	
	public static long soln(long a){
		return (long)Math.floor((-1+Math.sqrt(1+8*a))/2);
	}

}
