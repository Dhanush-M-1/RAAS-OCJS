import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WiseVasilisa{
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String[] s=bf.readLine().split(" ");
		int r1=Integer.parseInt(s[0]);
		int r2=Integer.parseInt(s[1]);
		
		s=bf.readLine().split(" ");
		int c1=Integer.parseInt(s[0]);
		int c2=Integer.parseInt(s[1]);
		
		s=bf.readLine().split(" ");
		int d1=Integer.parseInt(s[0]);
		int d2=Integer.parseInt(s[1]);
		
		int a, b, c, d;
		
		a=(r1+c1-d2)/2;
		b=(r1+c2-d1)/2;
		c=(r2+c1-d1)/2;
		d=(r2+c2-d2)/2;
		if((a>0&&b>0&&c>0&&d>0)&&(a!=b&&b!=c&&c!=d&&d!=a&&a!=c&&b!=d)&&(a<10&&b<10&&c<10&&d<10))
			if(a+b==r1&&a+c==c1&&c+d==r2&&b+d==c2&&a+d==d1&&c+b==d2)
				System.out.println(a+" "+b+"\n"+c+" "+d);
			else
				System.out.println(-1);
		else
			System.out.println(-1);
		
	}
	
}