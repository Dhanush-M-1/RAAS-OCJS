import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;


public class main {
	public static Scanner setFileIn(){
		try{
			Scanner input = new Scanner(new FileInputStream(new File ("test.txt")));
			return input;
		}catch(Exception e){
			return null;
		}
	}
	public static Scanner setSysIn(){
		Scanner input = new Scanner(new BufferedInputStream(System.in));
		return input;
	}
	public static boolean noSame(int a, int b,int c, int d){
		int[] oneToNine = new int[10];
		oneToNine[a]++;
		
		oneToNine[b%10]++;
		
			oneToNine[c%10]++;
	
			oneToNine[d%10]++;
		for (int i= 0; i<=9;i++){
			if (oneToNine[i]>=2){
				return false;
			}
		}
		
	return true;
	}

	public static void main(String args[]){
		Scanner input = setSysIn();
		int r1 = input.nextInt();
		int r2 = input.nextInt();
		int c1 = input.nextInt();
		int c2 = input.nextInt();
		int d1 = input.nextInt();
		int d2 = input.nextInt();
		int ok = 0;
		int x1=0,x2=0,x3=0,x4=0;
		for (int a= 1 ;a<=9;a++){
			for (int b= 1 ;b<=9;b++){
				for (int c= 1 ;c<=9;c++){
					for (int d= 1 ;d<=9;d++){
						if ((a+b == r1) && (c+d == r2)
						&&	(a+c == c1) && (b+d == c2)
						&&  (a+d == d1) && (b+c == d2)
						&&  noSame(a,b,c,d)){
						ok = 1;
						x1 = a; x2 = b; x3 = c; x4 =d;
						}
					}
				}
			}
		}
		if (ok == 1){
			System.out.printf("%d %d\n%d %d\n",x1,x2,x3,x4);
		}else {
			System.out.println(-1);
		}
	}

	
	
}
