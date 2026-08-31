import java.util.Scanner;public class WinOrFreeze {	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long l = (long)Math.sqrt(n), f=-1 , ff=-1, fn=0,i=l;
		boolean y = false;	a:for (i = 2 ; i <= l; i++){	if(n % i == 0){	n/=i;	fn++;	f = i;	while (n%i==0){n/=i;	fn++;	y=true;}		break a;}}
		for(; i <= l; i++){	while(n % i == 0){	n/=i;	fn++;	ff = i;	}}	fn++;
		if(f == l && fn <=3 )System.out.println("2");
		else if(fn<2)System.out.println("1\n0");
		else if ( fn == 2) System.out.println("2");
		else if ( y) System.out.println("1\n"+(f*f));
		else System.out.println("1\n"+(f*ff));	}}