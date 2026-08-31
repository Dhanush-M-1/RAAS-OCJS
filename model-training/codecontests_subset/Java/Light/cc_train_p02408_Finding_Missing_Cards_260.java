import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a;
		String mark;
		int[] s = new int[13];int[] h = new int[13];
		int[] c = new int[13];int[] d = new int[13];
		for (int b=0;b<n;b++){
			mark=sc.next();
			a=sc.nextInt();
			if (mark.equals("S")){
				s[a-1]=1;
			}else if (mark.equals("H")){
				h[a-1]=1;
			}else if (mark.equals("C")){
				c[a-1]=1;
			}else if (mark.equals("D")){
				d[a-1]=1;
			}
		}
		for (int e=0;e<13;e++){
			if (s[e]==0){
				System.out.println("S "+(e+1));
			}
		}
		for (int f=0;f<13;f++){
			if (h[f]==0){
				System.out.println("H "+(f+1));
			}
		}
		for (int g=0;g<13;g++){
		if (c[g]==0){
			System.out.println("C "+(g+1));
			}
		}
		for (int i=0;i<13;i++){
			if (d[i]==0){
				System.out.println("D "+(i+1));
			}
		}
	}
}