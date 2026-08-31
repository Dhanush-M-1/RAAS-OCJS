import java.util.Scanner;

public class AAAA {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int a = sc.nextInt();
	int b= sc.nextInt();
	int mid = (a+b)/2;
	int total = 0;
	int min = Math.min(a, b);
	int max = Math.max(a, b);
	int dist1 = mid-min;
	int dist2 = max-mid;
//	System.out.println(dist1+" "+dist2+ " "+mid);
	if(mid*2!=Math.abs(a-b))
		total+=((dist1)*(dist1+1)/2+(dist2)*(dist2+1)/2);
	else
		total+=(dist1)*(dist1+1);
	System.out.println(total);
}
}
