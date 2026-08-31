import java.io.PrintWriter;
import java.util.Scanner;
public class Div2_303C {
public static void main(String[] args){
	Scanner in=new Scanner(System.in);
	PrintWriter out=new PrintWriter(System.out,true);
	int n=in.nextInt(),s=2;
	int [] a=new int[n],b=new int[n];
	for(int i=0; i<n;i++){
		a[i]=in.nextInt();
		b[i]=in.nextInt();
	}	
	if(n==1)s--;
	for(int i=1; i<n-1; i++){
		if(a[i]-b[i]>a[i-1])s++;
		else if(a[i+1]>a[i]+b[i]){
			s++;
			a[i]+=b[i];
		}
	}
	out.println(s);
	}
}
