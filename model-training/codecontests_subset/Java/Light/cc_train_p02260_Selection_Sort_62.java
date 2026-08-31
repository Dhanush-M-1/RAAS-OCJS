import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int array[] = new int[N];
		int minj, tmp, pointer = 0, count = 0;

		for(int i = 0; i < array.length; i ++){
			array[i] = sc.nextInt();
		}

		for(int i = 0; i < array.length; i ++){
			minj = Integer.MAX_VALUE;
			for(int j = i ; j < array.length; j++){
				if(i != j){
					if(array[j] < minj){
					minj = array[j];
					pointer = j;
					}
				}
			}
			if(array[i] > minj){
				tmp = array[i];
				array[i] = minj;
				array[pointer] = tmp;
				count++;
			}
		}
		for(int i = 0; i < array.length; i++){
			if(i == array.length -1){
				System.out.println(array[i]);
			}else{
				System.out.print(array[i] + " ");
			}
		}
		System.out.println(count);
		sc.close();
	}

}

