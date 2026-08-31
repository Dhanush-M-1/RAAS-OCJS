import java.util.Scanner;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int k = sc.nextInt();
		
		int [] cal = new int [n];
		int [] result = new int [n];
		
		int work=0,max=0,x=0;
		
		for(int i = 0; i < n; i++){
			cal[i] = sc.nextInt();
		}
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(cal[i]>cal[j]){
					work = cal[j];
					cal[j] = cal[i];
					cal[i] = work;
				}
			}
		}
		for(int i = 0; i < n; i++){
			x = 0;
			for(int j = 0; j < i; j++){
				x += cal[j];
				}
				result[i] = (k+x)/(a+(b*i));
		}
		for(int i = 0; i < n; i++){
			if(result[i]>max){
				max = result[i];
			}
		}
		System.out.println(max);
		// TODO Auto-generated method stub

	}

}