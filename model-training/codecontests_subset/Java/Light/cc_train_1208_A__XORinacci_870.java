import java.util.*;
public class xorniacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
while(t-->0)
{
int a=sc.nextInt();
int b=sc.nextInt();
int n=sc.nextInt();
int k=n%3;
if(k==0)
	System.out.println(a);
else if(k==1)
	System.out.println(b);
else
	System.out.println(a^b);
}
}

}
