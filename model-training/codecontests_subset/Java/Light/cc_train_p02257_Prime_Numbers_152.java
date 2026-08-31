import java.util.Scanner;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sosu = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
        	sosu += sagyo(x);
        }
        System.out.println(sosu);
    }
	
	private static int sagyo(int x){
		int ruutox = (int)Math.sqrt(x);
		for(int i = 2; i <= ruutox; i++){
			int yakusu = 0;
			int x1 = x % i;
			if(x1 == 0){
				return 0;
			}
		}
		return 1;
	}
}
