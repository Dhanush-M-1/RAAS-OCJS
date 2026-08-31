import java.util.Scanner;


public class A526 {

	public static void solve(){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		char [] s = in.next().toCharArray();
		for(int i=1;i<=n/4;++i){
			for(int j=0;j+4*i<n;++j){
				if(s[j]=='*'&&s[j+i]=='*'&&s[j+2*i]=='*'&&s[j+3*i]=='*'&&s[j+4*i]=='*'){
					System.out.println("yes");
					return ;
				}//if
			}//for
		}//for
		System.out.println("no");
		return;
	}
	public static void main(String [] args){
		new A526().solve();
	}
}
