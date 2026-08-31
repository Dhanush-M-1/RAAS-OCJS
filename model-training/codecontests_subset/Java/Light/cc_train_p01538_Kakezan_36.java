import java.util.Scanner;

public class Main {

	static int N;
	
	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		N=cin.nextInt();
		while(N--!=0){
			String s = cin.next();
			if(s.length()==1){
				System.out.println(0);
				continue;
			}
			int ans=0;
			while(true){
				ans++;
				int max=-1;
				for(int i=1;i<s.length();i++){
					int a=Integer.parseInt(s.substring(0,i));
					int b=Integer.parseInt(s.substring(i));
//					System.out.println(a+" "+b);
					max=Math.max(a*b,max);
				}
				if(max<10){
					System.out.println(ans);
					break;
				}
				else{
					s=max+"";
				}
			}

			
		}
	}

}