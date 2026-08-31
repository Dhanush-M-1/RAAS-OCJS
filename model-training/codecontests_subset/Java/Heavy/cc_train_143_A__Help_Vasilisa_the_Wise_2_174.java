
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HelpVasilia {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new  StringTokenizer(bf.readLine());
		int r1=Integer.parseInt(st.nextToken());
		int r2=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(bf.readLine());
		int c1=Integer.parseInt(st.nextToken());
		int c2=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(bf.readLine());
		int d1=Integer.parseInt(st.nextToken());
		int d2=Integer.parseInt(st.nextToken());
		boolean not_possible=false;
		int x=(r1-c2+d1)/2;
		int y=r1-x;
		int m=c1-x;
		int n=c2-y;
		if((r1-c2+d1)%2!=0 || x<1|| y<1||m<1|| n<1 || x>9 || y>9|| n>9 || m>9 || check(x,y,m,n)|| 
				(x+y)!=r1 || (m+n)!= r2 || (x+m)!= c1 || (y+n) != c2 || (x+n) != d1 || (y+m)!= d2)
			not_possible=true;
		if(not_possible)
			System.out.println(-1);
		else{
			System.out.println(x+" "+y);
			System.out.println(m+" "+n);
		}
		
	}
	public static boolean check(int x, int y,int m,int n){
		if(x==y|| x==m|| x==n || y==n|| y==m || m==n)
			return true;
		return false;
	}
}
