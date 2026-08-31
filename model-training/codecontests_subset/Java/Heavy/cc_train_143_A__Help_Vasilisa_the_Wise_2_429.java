import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int r1=input.nextInt();
		int r2=input.nextInt();
		int c1=input.nextInt();
		int c2=input.nextInt();
		int d1=input.nextInt();
		int d2=input.nextInt();
		for(int i=1;i<=9;i++){
			int row11=i;
			int row12=r1-i;
			if(row12<0||row12==0||row12>=10||row12==i){continue;}
			int row21=c1-i;
			if(row21<0||row21==0||row21>=10||row21==i||row21==row12){continue;}
			int row22=c2-row12;
			if(row22<0||row22==0||row22>=10||row22==i||row22==row21||row22==row12){continue;}
			if(row11+row22==d1&&row21+row12==d2&&row11+row12==r1&&row21+row22==r2&&row11+row21==c1&&row12+row22==c2){
				System.out.println(row11+" "+row12);
				System.out.println(row21+" "+row22);
				System.exit(0);
			}
		}
		System.out.println(-1);
			
		}
	
		
		
		
	
	}
	
	

