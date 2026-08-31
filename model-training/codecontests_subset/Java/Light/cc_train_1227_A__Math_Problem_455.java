import java.util.Scanner;

public class Jonny {
static  Scanner in=new Scanner(System.in);
public static void main(String args[]){
	int t=in.nextInt();
	for(int i=0;i<t;i++) {
		int n=in.nextInt();
		int[][] a=new int[n][2];
		for(int j=0;j<n;j++)
			for(int k=0;k<2;k++)a[j][k]=in.nextInt();
		//Arrays.sort(a, Comparator.comparingInt(arr -> arr[1]));
		int max=0; int min=a[0][1];
		for(int j=0;j<n;j++) {
			if(a[j][1]<min)min=a[j][1];
		if(a[j][0]>max)max=a[j][0];
		}
		if(max-min<0)System.out.println(0);
		else System.out.println(max-min);
	}
	
}}