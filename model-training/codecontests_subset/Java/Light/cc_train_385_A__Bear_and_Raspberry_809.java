import java.util.Scanner;

public class BearandRaspberry {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int c=sc.nextInt();
	int max=0;
	int temp=0;
	while(n--!=0) {
		int crrnt=sc.nextInt();
		if((temp-crrnt-c)>max) {
			max=temp-crrnt-c;
		}
		temp=crrnt;
	}
	System.out.println(max);
}
}
