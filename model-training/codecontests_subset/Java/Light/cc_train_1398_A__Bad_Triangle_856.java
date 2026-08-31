import java.util.Scanner;

public class triangle {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		int t=s.nextInt();
		int b[]=new int [3];
		int c=0;
		while(t!=0) {
			int l=s.nextInt();
			int a[]=new int[l];
			
		for(int i=0;i<l;i++) {
			a[i]=s.nextInt();			
		}	
		
		if(a[0]+a[1]<=a[l-1]) {
			
			System.out.println("1"+" 2 "+l);
			
		}
		else {
			System.out.println("-1");}
		
			t--;
		}
	}

}
