import java.util.*;

public class solve{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
int t=sc.nextInt();
while(t-->0){
       int n =sc.nextInt();
int min=0;
int max=1000000000;
for(int i=0;i<n;i++){
     int a =sc.nextInt();
     int b =sc.nextInt();
    min=Math.max(min,a);
    max=Math.min(max,b);
}
if(n==1 || min<=max)
System.out.println("0");
else System.out.println(Math.abs(min-max));
}

	}
}