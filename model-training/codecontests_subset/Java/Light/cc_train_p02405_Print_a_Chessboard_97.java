import java.util.*;
class Main{
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args){
		while(true){
			int h=s.nextInt(),
			    w=s.nextInt();
			if((h|w)==0)
				break;
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					System.out.print(((i+j)%2==0)?"#":".");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}