import java.util.Scanner;

class Main
{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int[] n = new int[10000];
		
		int N = scan.nextInt();
		
		int kai = N;
		int x = 0;
		
		for(int i=0; i<N; i++){
			n[i] = scan.nextInt();
		}
		
		for(int i=0; i<N; i++){
			if(n[i]%2==0 && n[i]!=2){
				kai--;
				x++;
				continue;
			}
			for(int q=2; q<=Math.sqrt(n[i]); q++){
				if(n[i]%q==0){
					kai--;
					break;
				}
			}
		}
		
		System.out.println(kai);
	}
}
