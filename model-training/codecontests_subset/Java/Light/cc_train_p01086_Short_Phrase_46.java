import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = Integer.parseInt(sc.nextLine());
			if(n == 0) break;
			
			int[] array = new int[n];
			for(int i = 0; i < n; i++){
				array[i] = (sc.nextLine()).length();
			}
			
			for(int i = 0; i < n; i++){
				int sum = 0, flag = 0, pos = i;
				while(true){
					sum += array[pos];
					if(sum == 5 && (flag == 0 || flag == 2)){
						sum = 0;
						flag++;
					}else if(sum == 7 && (flag == 1 || flag == 3 || flag == 4)){
						sum = 0;
						flag++;
						if(flag == 5){
							break;
						}
					}else if(sum > 7){
						break;
					}
					pos++;
				}
				if(flag == 5){
					System.out.println(i+1);
					break;
				}
			}
		}
	}
}