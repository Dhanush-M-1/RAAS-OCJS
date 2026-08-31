import java.util.*;
public class  test{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		int t=0;
		t=sc.nextInt();
		while(t>0) {
			t--;
			int n=sc.nextInt();
			int a=-1,b=-1,c=-1,d=-1;
			String arr[]=new String[n];
			for(int i=0;i<n;i++) {
				arr[i]=sc.next();
				if(i==0)
					a=Integer.parseInt(Character.toString(arr[0].charAt(1)));
				else if(i==1 && b==-1)
					b=Integer.parseInt(Character.toString(arr[1].charAt(0)));
				else if(i==n-2)
					c=Integer.parseInt(Character.toString(arr[n-2].charAt(n-1)));
				else if(i==n-1)
					d=Integer.parseInt(Character.toString(arr[n-1].charAt(n-2)));
			}
			if(n==3) {
				c=Integer.parseInt(Character.toString(arr[n-2].charAt(n-1)));
			}
			if((a+b==0 && c+d==2) ||(a+b==2 && c+d==0) )
				System.out.println("0");
			else if((a+b==2 && c+d==2) ||(a+b==0 && c+d==0) ) {
				System.out.println("2");
				System.out.println("1"+" "+"2");
				System.out.println( "2"+" "+"1");
			}
			else if((a+b==1 && c+d==1)) {
				System.out.println("2");
				if(a==1)
					System.out.println("1"+" "+ "2");
				else
					System.out.println( "2"+" "+"1");
				if(c==0)
					System.out.println( (n-1) +" "+(n));
				else
					System.out.println((n) + " "+(n-1));
			}
			else {
				System.out.println("1");
				if(a!=b) {
					if(c+d==2) {
						if(a==1) {
							System.out.println("1"+" "+ "2");
						}
						else {
							System.out.println("2"+" "+"1");
						}
					}
					else {
						if(a==0) {
							System.out.println("1"+" "+ "2");
						}
						else {
							System.out.println("2"+" "+"1");
						}
					}
				}
				else {
					if(a+b==2) {
						if(c==1) {
							System.out.println((n-1) +" "+(n));
						}
						else {
							System.out.println((n) +" "+(n-1));
						}
					}
					else {
						if(c==0) {
							System.out.println((n-1) +" "+(n));
						}
						else {
							System.out.println((n)+" "+(n-1));
						}
					}
				}
			}
		}
	}

}
