
import java.util.Scanner;

public class question1 {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		
		int n=s.nextInt();
		
		int a=1;
		int b=2;
		int c=3;
		int p=a,q=b,r=c;
		boolean flag=false;
		
		for(int i=0;i<n;i++){
			int x=s.nextInt();
			
			if(x!=p && x!=q){
				System.out.println("NO");
				flag=true;
				break;
			}
			
			p=x;
			q=r;
			
			if((p==1 && q==2) || (q==1 && p==2)){
				r=3;
			}else if((p==2 && q==3) || (p==3 && q==2)){
				r=1;
			}else{
				r=2;
			}
		}
		
		if(flag==false){
			System.out.println("YES");
		}

	}

}
