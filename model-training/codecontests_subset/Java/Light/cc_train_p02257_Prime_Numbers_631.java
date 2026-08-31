import java.util.Scanner;
public class Main{
    public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	int n = Integer.parseInt(scan.nextLine());
	int cnt = 0;
        for (int i = 0; i < n; i++) {
	    int a = Integer.parseInt(scan.nextLine());
	    if (isPrime(a)) {
		cnt++;
	    }
	}
	System.out.println(cnt);
    }
    public static boolean isPrime(int a){
	if (a == 2) {
	    return true;
	}
	if (a % 2 == 0) {
	    return false;
	}
	for (int i = 3; i <= Math.sqrt(a); i++) {
	    if (a % i == 0) {
		return false;
	    }
	}
	return true;
    }
}