import java.util.Scanner;

public class contest3_D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] h = new int[n];
		
		x[0] = sc.nextInt();
		h[0] = sc.nextInt();
		
		int pos = x[0];
		
		int res = 1;
		
		for(int i = 1; i<n; i++) {
			x[i] = sc.nextInt();
			h[i] = sc.nextInt();
			
			if(i>1) {
				if(x[i-1]-h[i-1]>pos) {
					// можно повалить влево
					res++;
					pos = x[i-1];
					//System.out.println("Валю "+x[i-1]+" влево");
				}else if(x[i-1]+h[i-1]<x[i]) {
					// можно повалить вправо
					res++;
					pos = x[i-1]+h[i-1];
					//System.out.println("Валю "+x[i-1]+" вправо");
				}else {
					//повалить нельзя
					pos = x[i-1];
				}
			}
		}
		
		if(n==1) {
			System.out.println(1);
		}else if(x[x.length-1]==x[0]) {
			System.out.println(1);
		}else {
		System.out.println(res+1);
		}
		
		
	}

}
