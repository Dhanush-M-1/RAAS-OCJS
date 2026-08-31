import java.util.Scanner;

public class problem143A {
	/*
	 x1 x2
	 x3 x4
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		
		for(int x1=1;x1<=9;x1++){
			int x2 = r1-x1;
			int x3 = c1-x1;
			
			if((c2-x2) != (r2-x3)) continue;
			else{
				int x4 = c2-x2;
				if(((x1+x4) == d1) &&((x2+x3) == d2)){
					if(x1>9 || x2>9 || x3>9 || x4>9) continue;
					if(x1<1 || x2<1 || x3<1 || x4<1) continue;
					if(x1 != x2 && x2 != x3 && x3 != x4 && x1 != x3 && x1 != x4 && x2 != x4){
						System.out.println(x1+" "+x2);
						System.out.println(x3+" "+x4);
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}

}
