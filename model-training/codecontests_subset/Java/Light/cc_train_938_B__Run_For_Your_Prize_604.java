import java.util.Scanner;

public class taskB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan = new Scanner(System.in);
int n = scan.nextInt();
int answ = 0;
for(int i=0;i<n;i++) {
	int r = scan.nextInt();
	if (r<=1000000-r) {
		answ = Math.max(r-1, answ);
	}else {
		answ = Math.max(1000000-r, answ);
	}
}
System.out.println(answ);
	}

}
