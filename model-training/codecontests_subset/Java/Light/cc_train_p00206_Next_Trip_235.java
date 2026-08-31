import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scan =  null;
		try{
			scan = new Scanner(System.in);
			int aim;
			while((aim = scan.nextInt()) != 0){
				boolean check =false;
				for(int i = 0 ; i < 12 ; i++){
					aim -= scan.nextInt() - scan.nextInt();
					if(check == false && aim <=0){
						System.out.println(i + 1);
						check = true;
					}
				}
				if(!check){
					System.out.println("NA");
				}
			}
		}finally{
			if(scan !=null)scan.close();
		}
	}
}