import java.util.*;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int [] array = new int[n];
		int max = 0, soeji = 0, j, kijyun,hikaku = 0, x = 0;
		int daikin = 0;
		int kijikakaku = sc.nextInt();
		int sabukakaku = sc.nextInt();
		int kiji = sc.nextInt();
		for(int i = 0; i < n; i++){
			array[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
			for(j = i; j < n; j++){
				if(j == i){
					max = array[j];
					 
				}
				else if (max < array[j]){
					max = array[j];
					soeji = j;
				}
			}
			array[soeji] = array[i];
			array[i] = max;
		}
		kijyun = kiji / kijikakaku;
		for(int i = 0; i < n; i++){
			hikaku = array[i] / sabukakaku;
			if(kijyun >= hikaku){
				break;
			}
			else {
				x += array[i];
				daikin =kijikakaku+(sabukakaku*(i+1));
				kijyun = (kiji + x)/daikin;
			}
		}
		System.out.println(kijyun);	
	}

}