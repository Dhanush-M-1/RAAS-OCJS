import java.util.Scanner;

public class subseq {

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int a =sc.nextInt();
		for(int j=0;j<a;j++)
				{
			int b=sc.nextInt();
			int c=sc.nextInt();
			int []d=new int[b];
			int []e=new int[c];
			for(int i=0;i<b;i++) {
				d[i]=sc.nextInt();
			}for(int i=0;i<c;i++) {
				e[i]=sc.nextInt();
			}
			int l=0;for(int i=0;i<b;i++) {
				for(int k=0;k<c;k++) {
					if(e[k] ==d[i]) {
						l=e[k];
						break;
					}
				}
				
			}if(l !=0) {
				System.out.println("YES"+" ");
				System.out.println("1"+" "+l);
				
			}
			else {
				System.out.println("NO");
			}
			
				}

	}

}
