import java.util.Scanner;
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(),A=sc.nextInt(),B=sc.nextInt(),C=sc.nextInt();
		int[] price = new int[N];
		for(int i=0; i<price.length; i++){
			price[i]=sc.nextInt();
		}
		int cnt=0,work=0;
		int[] cal = new int[price.length];
		for(int i=0; i<price.length; i++){
			for(int j=0; j<price.length; j++){
				if(price[i]>price[j]){
					work=price[i];
					price[i]=price[j];
					price[j]=work;
				}
			}
		}
		for(int i=0; i<price.length; i++){
			for(int j=0; j<i+1; j++){
				cnt+=price[j];
			}
			cnt+=C;
			cal[i]=cnt;
			cnt=0;
		}
		int[] result = new int[price.length];
		for(int i=0; i<price.length; i++){
			result[i]=(cal[i])/(A+((i+1)*B));
		}
		int max=result[0];
		for(int i=0; i<price.length; i++){
			if(max<result[i]){
				max=result[i];
			}
		}
		System.out.println(max);
		// TODO Auto-generated method stub

	}
}