
import java.math.BigInteger;
import java.util.*;
public class Main {





public static void main(String[] args)
{
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int c=sc.nextInt();
	
pair arr[]=new pair[n];
pair cc[]=new pair[c];
for(int i=0;i<n;i++) {
	int x=sc.nextInt();
	int y=sc.nextInt();
	pair p=new pair(x,y);
	arr[i]=p;
}
for(int i=0;i<c;i++) {
	int x=sc.nextInt();
	int y=sc.nextInt();
	pair p=new pair(x,y);
	cc[i]=p;
}
long ans=0;

for(int i=0;i<n;i++) {
	long min=Long.MAX_VALUE;
	for(int j=0;j<c;j++) {
					long dis=Math.abs(arr[i].x-cc[j].x)+Math.abs(arr[i].y-cc[j].y);
					if(dis<min) {
						min=dis;
						ans=j;
					}
	}
	System.out.println(ans+1);
}
	

}

}

class pair{
	int x,y;
	pair(int x,int y){
		this.x=x;
		this.y=y;
	}
}
