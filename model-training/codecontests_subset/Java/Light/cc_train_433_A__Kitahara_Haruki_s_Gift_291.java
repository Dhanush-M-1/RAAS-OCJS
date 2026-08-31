import java.util.Scanner;


public class Round248Div2A {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n  =  sc.nextInt();
	int x=0;
	int y=0;
	for (int i = 1; i <=n; i++) {
		int a=sc.nextInt();
		if(a==100) x++;
		if(a==200) y++;
	}
	if(x%2==1){
		System.out.println("NO");
	}else{
		if(x==0 && y%2==1)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
}
}