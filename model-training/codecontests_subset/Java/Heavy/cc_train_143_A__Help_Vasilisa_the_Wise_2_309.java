import java.util.*;
public class VasilisaTheWise2 {

	public static void main(String[] args) {
	Scanner scn = new Scanner(System.in);
	int r1=scn.nextInt();
	int r2=scn.nextInt();
	int c1=scn.nextInt();
	int c2=scn.nextInt();
	int d1=scn.nextInt();
	int d2=scn.nextInt();
	boolean flag=false;
	int[] arr=new int[4];
		int rem=(r1+c1+d1);
		int sub=(r2+c2+d2);
		if(sub%2!=0) {
			flag=true;
			System.out.println("-1");
			}
		else
		sub=sub/2;
		if(!flag) {
			
		rem=rem-sub;
		if(rem%3!=0) {
			flag=true;
			System.out.println("-1");
		}
		else
		{	arr[0]=rem/3;
		arr[1]=r1-arr[0];
		arr[2]=c1-arr[0];
		arr[3]=d1-arr[0];
		if(arr[1]==0||arr[2]==0||arr[0]==0||arr[3]==0) {
			flag=true;
			System.out.println("-1");
		}
		}
		
		}
		for(int i=0;!flag && i<3;i++) {
			for(int j=i+1;j<4;j++) {
				if(arr[i]==arr[j]) {
					flag=true;
					System.out.println("-1");
					break;
				}
				if(arr[i]>9 || arr[i]<0 ||arr[j]>9 || arr[j]<0) {
					flag=true;
					System.out.println("-1");
					break;
				}
			}
		}
		if(!flag) {
			System.out.println(arr[0]+" "+arr[1]+"\n"+arr[2]+" "+arr[3]);
//			else 
//				System.out.println("-1");
			}
	}

}
