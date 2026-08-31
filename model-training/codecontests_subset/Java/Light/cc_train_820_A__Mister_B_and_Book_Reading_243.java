import java.util.*;
public class A820{
	public static void main(String args[]){
		int sum=0;
		int flag=0;
		int x=0;
		int c,v0,v1,a,l;
		Scanner scan = new Scanner(System.in);
		c= scan.nextInt();
		v0= scan.nextInt();
		v1= scan.nextInt();
		a= scan.nextInt();
		l= scan.nextInt();
		while(sum<c){
			if((v0+x*a)>v1){
				sum+=v1;
			}
			else{
			sum+=v0+x*a;
		}
			if(sum>=c){
				System.out.println(x+1);
				flag=1;
				break;
			}
			sum-=l;
			x++;
		}
		if(flag==0){
			System.out.println(x+1);
		}
	}
}