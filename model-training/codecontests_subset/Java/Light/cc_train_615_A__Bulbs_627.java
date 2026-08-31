import java.util.Scanner;
public class test {
	public static void main(String[] args){
	Scanner s=new Scanner(System.in);
	int n=s.nextInt();
	int o=0;
	int m=s.nextInt();
	int ar[]=new int[m];
	for(int i=0;i<n;i++){
		int d=s.nextInt();
		for(int j=0;j<d;j++){
			int y=s.nextInt();
			if(ar[y-1]==0){
				ar[y-1]=1;
				o++;
			}}}
	if(o==m)
		System.out.println("YES");
		else System.out.println("NO");
	}}