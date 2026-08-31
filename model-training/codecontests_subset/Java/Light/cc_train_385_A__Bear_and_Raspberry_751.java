import java.util.* ;
public class honey_barrel{
	public static void main(String []args){
		Scanner sc = new Scanner(System.in) ;
		int n,c,ans,pre,curr;
		n = sc.nextInt() ;
		c = sc.nextInt() ;
		ans = 0 ; 
		pre = curr = -1;
		for(int i=1;i<=n;i++){
			curr = sc.nextInt() ;
			if(pre != -1){
				ans = Math.max(ans,pre-curr) ;
			}
			pre = curr ; 
		}
		ans = Math.max(ans-c,0) ;
		System.out.println(ans) ;
	}
}

