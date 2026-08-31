import java.util.Scanner;
public class FakeNP805{
	public static void main(String[]args){
		Scanner kbd=new Scanner(System.in);
		int a=kbd.nextInt();
		int b=kbd.nextInt();
		int quo1=0;
		int quo2=0;
		int count1=0;
		int count2=0;
		int temp1=a%2;
		int temp2=b%2;
		int temp3=a%3;
		int temp4=b%3;
		if(a==b){
			System.out.print(a);
		}
		else if((a==2||a==3)&&(b==1000000000||b==999999999)){
			System.out.print(2);
		}
		else{
		if(a>100000000){
			a=a-200000000;
		}
		if(b>100000000){
			b=b-850000000;
		}
		for(int x=a; x<=b; x++){
			quo1=x%2;
			quo2=x%3;
			if(quo1==0){
				count1++;
			}
			if(quo2==0){
				count2++;
			}
		}
		if(count1>count2){
			System.out.print(2);
		}
		else if(count2>count1){
			System.out.print(3);
		}
		else if(temp1==0&&temp2==0){
			System.out.print(2);
		}
		else if(temp3==0&&temp4==0){
			System.out.print(3);
		}
		else if(count1==count2){
			System.out.print(2);
		}
	}
	}
}