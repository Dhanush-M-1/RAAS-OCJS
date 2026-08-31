import java.util.Scanner;
class Main{
	public static void main(String[] args){
		Scanner stdin=new Scanner(System.in);
		int H;
		int W;
		
		while(true){
			H=stdin.nextInt();
			W=stdin.nextInt();
			if(H==0 && W==0) {break;}
			for(int i=1;i<=H;i++){
				for(int j=1;j<=W;j++){				
					if((i%2)==1&&(j%2)==1 || (i%2)==0&&(j%2)==0 )System.out.print("#");
					else System.out.print(".");				
						}
			
				System.out.print("\n");
		}
		System.out.print("\n");
	}
	}
}

