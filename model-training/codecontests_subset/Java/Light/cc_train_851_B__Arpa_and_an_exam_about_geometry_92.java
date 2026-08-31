import java.util.Scanner;

public class Geometry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long ax,ay,bx,by,cx,cy;
		ax=in.nextLong();
		ay=in.nextLong();
		bx=in.nextLong();
		by=in.nextLong();
		cx=in.nextLong();
		cy=in.nextLong();
		long ab=(bx-ax)*(bx-ax)+(by-ay)*(by-ay);
		long bc=(bx-cx)*(bx-cx)+(by-cy)*(by-cy);
		if((bx-ax)*(by-cy)!=(bx-cx)*(by-ay)&&ab==bc)
			System.out.print("YES");
		else
			System.out.print("NO");
		
	}

}
