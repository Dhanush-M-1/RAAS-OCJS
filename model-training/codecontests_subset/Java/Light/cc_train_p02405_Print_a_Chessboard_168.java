import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner sr = new Scanner(System.in);
		while(true){
			int h = sr.nextInt();
			int w = sr.nextInt();
			if(h==0&&w==0) break;
			for(int y=0; y<h; y++){
				for(int x=0; x<w; x++){
					if((x+y)%2==0){
						System.out.print("#");
					}else{
						System.out.print(".");
					}
				}
				System.out.println();
			}
		System.out.println();
		}
	}
}