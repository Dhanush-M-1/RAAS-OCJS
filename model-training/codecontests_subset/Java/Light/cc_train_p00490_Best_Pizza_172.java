
import java.util.Scanner;

//best pizza
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //??????????????°????¨????
		int a = sc.nextInt(); //?????°?????????
		int b = sc.nextInt(); //??????????????°?????????
		int calorie[] = new int [n+1];
		for(int i = 0;i<n+1;i++){
			calorie[i] = sc.nextInt(); 
		}
		int box,work;
		for(int i = 1; i < n+1; i++) { //??????????????????
			box = i;
			for(int m = i + 1; m < n+1; m++) {
				if(calorie[m] > calorie[box]){
					box = m;
				}
			}
			work = calorie[i]; 
			calorie[i] = calorie[box]; 
			calorie[box] = work;
		}
		/*for(int i = 0;i<n+1;i++){
			System.out.println(calorie[i]);
		}*/
		int allcalorie = calorie[0],allcalorie2 = calorie[0];
		int nedan = a,nedan2 = a;
		int result = allcalorie / nedan,result2;
		for(int i = 1;i<n+1;i++){
			nedan2 = a + b*i;
			allcalorie2 = allcalorie2 + calorie[i];
			result = allcalorie / nedan;
			result2 = allcalorie2 / nedan2;
			if(result < result2){
				nedan = nedan2;
				allcalorie = allcalorie2;
				result = result2;
			}
		}
		System.out.println(result);
	}
}
			