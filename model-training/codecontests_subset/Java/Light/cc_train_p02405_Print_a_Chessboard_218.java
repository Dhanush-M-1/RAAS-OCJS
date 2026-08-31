import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		int h,w,i,j,t=0;
		for(;;){
			h=stdIn.nextInt();
			w=stdIn.nextInt();
			if(h<1&&w<1)break;
			for(i=0;i<h;i++){
				for(j=0;j<w;j++){
					if(t!=0)System.out.print(".");
					else System.out.print("#");
					t=~t;
				}
				if(w%2==0)t=~t;
				System.out.println();
			}
			System.out.println();
			t=0;
		}
	}
}
