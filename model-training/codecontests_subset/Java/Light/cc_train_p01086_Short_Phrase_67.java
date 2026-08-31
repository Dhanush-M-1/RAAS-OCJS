import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n=sc.nextInt();
			if(n==0) break;
			String gomi=sc.nextLine();
			int[] num = new int[n];
			for(int i=0;i<n;++i){
				String data = sc.nextLine();
				num[i]=data.length();
			}
			for(int i=0;i<n-4;++i){
				boolean flag=true;
				int d=num[i],count=0,ans=i+1,m=i;
				while(flag){
					if(count==5){ System.out.println(ans); i=n; break; }
					if(count==0||count==2){
						if(5<d) flag=false;
						else if(d==5){ d=0; count++; }
						else { m++; d+=num[m]; }
					} else {
						if(7<d) flag=false;
						else if(d==7){ d=0; count++; }
						else { m++; d+=num[m]; }
					}
				}
			}
		}
	}
}

