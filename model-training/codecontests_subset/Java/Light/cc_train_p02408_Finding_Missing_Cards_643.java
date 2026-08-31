import java.util.Scanner;
class Main {
  public static void main(String args[]) {
Scanner sc=new Scanner(System.in);
int [] [] cards=new int [4][13];
for(int q=0;q<4;q++) {
	for(int w=0;w<13;w++) {
		cards[q][w]=1;
	}
}
int a=sc.nextInt();
for(int i=-0;i<a;i++) {
	String egara=sc.next();
	int lank=sc.nextInt();
	if(egara.equals("S")) {
		cards[0][lank-1]=0;
	}
	else if(egara.equals("H")) {
		cards[1][lank-1]=0;
	}
	else if(egara.equals("C")) {
		cards[2][lank-1]=0;
	}
	else if(egara.equals("D")) {
		cards[3][lank-1]=0;
	}
}
for(int e=0;e<4;e++) {
	for(int r=0;r<13;r++) {
		if(cards[e][r]==1) {
			if(e==0) {
				System.out.println("S "+(r+1));
			}
			else if(e==1) {
				System.out.println("H "+(r+1));
			}
			else if(e==2) {
				System.out.println("C "+(r+1));
			}
			else if(e==3) {
				System.out.println("D "+(r+1));
			}
		}
	}
}
sc.close();
  }
}




