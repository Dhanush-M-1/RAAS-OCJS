import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int s[]=new int[13];
		int h[]=new int[13];
		int c[]=new int[13];
		int d[]=new int[13];
		for(int i=0;i<13;i++) {
			s[i]=0;
			h[i]=0;
			c[i]=0;
			d[i]=0;
		}
		String chara;
		int num;
		for(int i=0;i<n;i++) {
			chara = scan.next();
			num=scan.nextInt()-1;
			if(chara.equals("S"))s[num]=1;
			if(chara.equals("H"))h[num]=1;
			if(chara.equals("C"))c[num]=1;
			if(chara.equals("D"))d[num]=1;
		}

		for(int i=0;i<13;i++) if(s[i]==0) System.out.println("S "+(i+1));
		for(int i=0;i<13;i++) if(h[i]==0) System.out.println("H "+(i+1));
		for(int i=0;i<13;i++) if(c[i]==0) System.out.println("C "+(i+1));
		for(int i=0;i<13;i++) if(d[i]==0) System.out.println("D "+(i+1));

		scan.close();
	}

}
