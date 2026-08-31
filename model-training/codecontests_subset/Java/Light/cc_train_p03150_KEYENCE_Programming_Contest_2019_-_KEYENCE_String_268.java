import java.util.*;

class Main{
	public static void main(String[] $){
		Scanner s=new Scanner(System.in);
		
		String v=s.next();
		for(int i=0;i<=v.length();++i) {
			for(int j=i;j<=v.length();++j) {
				if("keyence".equals(v.substring(0,i)+v.substring(j))) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}
}