import java.util.Scanner;

public class Main{


	public static boolean isPrime(int num){
		//?´???°????????¶
		//????????????????°?????????´??°??§??????????????????
		if(num==1)return false;
		if(num==2)return true;
		if(num%2==0)return false;

		for(int i=3;i*i<=num;i+=2){
			if(num%i==0)return false;
		}

		return true;
	}



	public static void main(String[] args){

		int N;
		int box, cnt;

		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();

		cnt=0;
		for(int i=0;i<N;i++){
		box=scan.nextInt();

		if(isPrime(box)){cnt++;}
		}

		System.out.println(cnt);

		scan.close();

	}

}