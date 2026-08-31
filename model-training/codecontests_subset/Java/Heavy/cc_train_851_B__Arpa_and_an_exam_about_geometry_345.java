import java.util.*;
public final class Round431 {
		public static void main(String args[]){
			Scanner sc = new Scanner(System.in);
			long ax = sc.nextInt();
			long ay = sc.nextInt();
			long bx = sc.nextInt();
			long by = sc.nextInt();
			long cx = sc.nextInt();
			long cy = sc.nextInt();
			//float c=(cx*cx)+(cy*cy);
			long a=(ax-bx)*(ax-bx)+(ay-by)*(ay-by);
			long b=(bx-cx)*(bx-cx)+(by-cy)*(by-cy);
            
//			System.out.println(a+" "+b+" "+c);
//			float p=(b-a)/2;
//			float q=(b-c)/2;
//			float X=(q-p*(by-ay))/(ax-cx);
//			float Y=p-X*(bx-ax);
//			System.out.println(X+" "+Y);
//			float m1m2 = ((ay-Y)*(cy-Y)*(by-Y))/((ax-X)*(cx-X)*(bx-X));
//			System.out.println(m1m2);
			if(a==b && ((by-ay)*(cx-bx)!=(cy-by)*(bx-ax)))
					System.out.println("Yes");
			
			else
					System.out.println("No");
			sc.close();
		}
}
