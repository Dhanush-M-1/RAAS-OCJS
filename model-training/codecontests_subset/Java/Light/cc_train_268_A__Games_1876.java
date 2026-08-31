import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int h[][] = new int[t][2];
		
		for(int i = 0 ; i< t ; i++){
			h[i][0] = in.nextInt();
			h[i][1] = in.nextInt();
		}
		in.close();
		int count = 0;
		for(int i = 0 ; i<t ; i++){ // h
			for(int j = 0 ; j<t ; j++){ //g
				if(i == j) continue;
				if(h[i][0] == h[j][1]){
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
