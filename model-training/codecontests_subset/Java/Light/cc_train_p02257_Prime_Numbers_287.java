import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner stdIn=new Scanner(System.in);
		int n=stdIn.nextInt(),a,s=0,i,j;
		for(i=0;i<n;i++) {
			a=stdIn.nextInt();
			if(a==1) continue;
			for(j=2;j<=(int)Math.sqrt(a);j++) if(a%j==0) break;
			if(j==(int)Math.sqrt(a)+1) s++;
		}
		System.out.println(s);
	}
}
