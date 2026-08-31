import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean flag =true;
		int h;
		int w;
		String mark = "#";
		while(flag){
			h = sc.nextInt();
			w = sc.nextInt();
			if(h == 0 && w == 0){
				break;
			}
			for(int i = 0;i < h;i++){
				for(int j = 0;j < w;j++){
					if(j % 2 == i % 2){
						mark = "#";
					}else{
						mark = ".";
					}
					System.out.print(mark);
				}
				System.out.println();
			}
			System.out.println();
		}	
	}
}
