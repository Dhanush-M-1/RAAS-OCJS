import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		new Main().solve();
	}
	
	void solve(){
		Scanner sc=new Scanner(System.in);
		String x=sc.next();
		
		int count_s=0; 
		int count_t=0;
		int ans=0;
		for(int i=0;i<x.length();i++){
			if(x.charAt(i)=='S')count_s++;
			
			if(count_s>0){
				if(x.charAt(i)=='T'){
					count_s--;
				}
			}else{
				if(x.charAt(i)=='T'){
					ans++;
				}
			}
		}
		System.out.println(ans*2);
	}
}
