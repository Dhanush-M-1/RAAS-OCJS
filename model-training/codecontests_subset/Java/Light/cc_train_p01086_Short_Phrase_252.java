import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n= sc.nextInt();
			if(n==0)break;
			
			int flag = 0;
			int ans = 0;
			String[] s = new String[n];
			for(int i=0;i<n;i++) {
				s[i] = sc.next();
			}
			
			int[] haiku = {5,7,5,7,7};
			int c = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<=4;j++) {
					if(j==0 && haiku[0]==5) {
							c=i;
					}
					if(haiku[j]==0)continue;
					if(haiku[j]-s[i].length() >= 0) {
						haiku[j] -= s[i].length();
						if(j==4 && haiku[4]==0) {
							ans = c+1;
							flag = 1;
						}
						break;
					}
					else if(haiku[j]-s[i].length() < 0) {
						haiku[0]=5;haiku[1]=7;haiku[2]=5;haiku[3]=7;haiku[4]=7;
						i=c;
						break;
					}	
				}
				if(flag==1)break;
			}
			System.out.println(ans);
			
		}
	}

}

