import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int cnt = 0;

    for(int i = 0; i < n; ++i) {
    	if(isPrime(sc.nextInt())){
    		cnt += 1;
    	}
    }

    System.out.println(cnt);
  }

  public static boolean isPrime(int p) {
  	if(p == 2) return true;
  	if(p % 2 == 0) return false;
	for(int q = 3; q < Math.sqrt(p) + 1; q += 2){
		if(p % q == 0){
			return false;
		}
	}
  	return true;
  }
}