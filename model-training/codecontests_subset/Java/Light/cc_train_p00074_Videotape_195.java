import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		while(true){
			int h = stdIn.nextInt();
			int m = stdIn.nextInt();
			int s = stdIn.nextInt();
			
			if(h==-1&&m==-1&&s==-1){
				return;
			}
			
			int min = 120-((h*60)+m);
			int hour=0;
			if(s!=0){
				if(min==0){
					hour--;
				}
				min--;
				s=60-s;
			}
			
			int[] a = new int[6];
			if(min>=120){
				a[0]=2;
				a[1]=0;
			}
			else if(min>=60){
				a[0]++;
				a[1]=min-60;
			}
			else{
				a[1]=min;
			}
			a[2]=s;
			a[0]+=hour;
			System.out.printf("%02d:%02d:%02d\n",a[0],a[1],a[2]);
			
			a[3]=a[0]*3;
			a[4]=a[1]*3;
			a[5]=a[2]*3;
			
			if(a[5]>=60){
				a[4]++;
				a[5]-=60;
			}
			if(a[5]>=60){
				a[4]++;
				a[5]-=60;
			}
			if(a[4]>=60){
				a[3]++;
				a[4]-=60;
			}
			if(a[4]>=60){
				a[3]++;
				a[4]-=60;
			}
			
			System.out.printf("%02d:%02d:%02d\n",a[3],a[4],a[5]);
		}
	}
}