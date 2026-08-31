import java.util.*;
public class CommonSubsequence{
	public static void main(String arr[]){
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		
		
		while(p-- > 0){
			int flag = 0;
			int q = sc.nextInt();
			int r = sc.nextInt();
			int a[] = new int[q];
			int b[] = new int[r];
			for( int i=0;i<q;i++){
				a[i] = sc.nextInt();
			}
			for( int i=0;i<r;i++){
				b[i] = sc.nextInt();
			}
			for( int i=0;i<q;i++){
				for( int j=0;j<r;j++){
					if( a[i] == b[j] ){
						flag = 1;
						System.out.println("YES");
						System.out.println(1+" "+a[i]);	
						break;
					}
					
					
				}
				if( flag == 1)break;
			}
			if( flag == 0){
				System.out.println("NO");
			}
			
		}
	}
}