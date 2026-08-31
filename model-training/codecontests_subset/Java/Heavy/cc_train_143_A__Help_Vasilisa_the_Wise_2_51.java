import java.util.Scanner;
public class C102_A_Vanessa {
	static Scanner in = new Scanner ( System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]  l= new int[4];
		int[] ind = new int[6];
		boolean check=true;
		int i,j;
		for ( i=0;i<2;i++){
			ind[i]= in.nextInt();
			ind[4-i]= in.nextInt();
		}
		ind[2]= in.nextInt();
		ind[5]= in.nextInt();
		l[0]= ( ind[0]+ind[1]-ind[5])/2;
		l[1]=ind[0]-l[0];
		l[2]=ind[1]-l[0];
		l[3]=ind[2]-l[0];
		for (i=0;i<4;i++){
			for (j=i+1;j<4;j++) {
				if (l[i]==l[j]) check=false;
			}
			if (l[i]<1) check=false;
			if (l[i]>9) check=false;
					
			
		}
		for (i=0;i<4;i++){
			for (j=i+1;j<4;j++) {
				if ((i!=1)&&(j!=2)) if ((l[i]+l[j])!=ind[i+j-1]) check=false;
			}
		}
		
		if ((l[1]+l[2])!=ind[5]) check=false;
		
		if (check) {
			System.out.println(l[0]+" "+l[1]);
			System.out.println(l[2]+" "+l[3]);
		}
		else
			System.out.println(-1);
	}

}
