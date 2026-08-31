import java.util.Scanner;
public class common_sub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner obj=new Scanner(System.in);
		int query=obj.nextInt();
		for(int i=0;i<query;i++) {
			int n1=obj.nextInt();
			int n2=obj.nextInt();
			String s1=" ";
			for(int f=0;f<n1;f++) {
				s1+=obj.nextInt()+" ";
			}
			int res=-1;
			boolean go=true;
			for(int f=0;f<n2;f++) {
				int cur=obj.nextInt();
				if(go&&s1.indexOf(" "+cur+" ")!=-1) {
					res=cur;
					go=false;
				}
			}
			if(res!=-1) {
				System.out.println("YES");
				System.out.println(1+" "+res);
			}
			else System.out.println("NO");
		}
	}

}