import java.util.*;
public class AB {

	public static void main(String[] args) {
Scanner input = new Scanner(System.in);

int t,a,b,n;
t=input.nextInt();
int[]answer=new int[t];

for(int i=0;i<t;i++) {
	a=input.nextInt();
	b=input.nextInt();
	n=input.nextInt();
int xor=a^b;
n++;
if(n%3==0) {
	System.out.println(xor);
}
else if(n%3==1) {
	System.out.println(a);
}
else {
	System.out.println(b);
}
}
	}

}
