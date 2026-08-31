import java.util.*;
public class tG{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int[][] ar=new int[n][2];

		for(int i=0;i<ar.length;i++){
			ar[i][0]=in.nextInt();
			ar[i][1]=in.nextInt();
		}
		int c=0;
		for(int i=0;i<ar.length;i++){
			for(int j=0;j<ar.length;j++)
				if(i!=j&&ar[i][0]==ar[j][1])
					c++;	
			}
		System.out.println(c);
	}
}