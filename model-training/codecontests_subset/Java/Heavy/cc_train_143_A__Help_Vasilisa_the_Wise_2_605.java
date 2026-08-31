import java.util.*;

public class R102A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int r1 = scan.nextInt();
		int r2 = scan.nextInt();
		int c1 = scan.nextInt();
		int c2 = scan.nextInt();
		int d1 = scan.nextInt();
		int d2 = scan.nextInt();
		for(int i = 1; i < 10; i++){
			for(int j = 1; j < 10; j++){
				if(j == i) continue;
				for(int k = 1; k < 10; k++){
					if(k == i) continue;
					if(k == j) continue;
					for(int l = 1; l < 10; l++){
						if(l == i) continue;
						if(l == j) continue;
						if(l == k) continue;
						if(i+j == r1){
							if(i+k == c1){
								if(k+l == r2){
									if(j+l == c2){
										if(i+l == d1){
											if(j+k == d2){
												System.out.println(i+" "+j);
												System.out.println(k+" "+l);
												return;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(-1);
	}
}
