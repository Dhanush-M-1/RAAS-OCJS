import java.util.*;
public class p103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int a[]=new int[6];
		int b[]=new int [4];
		int c = 0 ;
		for (int i = 0; i < a.length; i++) {
			a[i]=in.nextInt();
		}
		b[0]=(a[0]+a[2]-a[5])/2;
		b[1]=a[0]-b[0];
		if (b[0]==b[1]) c = 1;
		b[2]=a[2]-b[0];
		if (b[2]==b[0]||b[2]==b[1]) c=1 ;
		b[3]=a[4]-b[0];
		if (b[3]==b[0]||b[3]==b[1]||b[3]==b[2]) c=1 ;
		if (b[1]+b[2]!=a[5]||b[1]+b[3]!=a[3]||b[2]+b[3]!=a[1]) c=1 ;{
			
		}{
			
		}
		for (int i = 0; i < b.length; i++) {
			if(c==1||b[i]<1||b[i]>9) {
				c=2;
				break;
			}
		}
		if (c==2) {
			System.out.println(-1);
		}else {
			System.out.print(b[0]+" "+b[1]);
			System.out.println();
			System.out.print(b[2]+" "+b[3]);
		}
	}

}
