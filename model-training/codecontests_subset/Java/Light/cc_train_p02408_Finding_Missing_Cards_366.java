import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner scan = null;
		try{
			scan = new Scanner(System.in);
			boolean[][] card = new boolean[4][13];
			String[] set ={"S","H","C","D"};
			int n = scan.nextInt();
			for(int i = 0 ; i < n;i++){
				String color = scan.next();
				int num = scan.nextInt();
				for(int j = 0;j< set.length;j++){
					if(set[j].equals(color)){
						card[j][num -1] = true;
						break;
					}
				}
			}
			for(int i = 0;i < card.length;i++){
				for(int j = 0 ;j < card[i].length;j++){
					if(!card[i][j]){
						System.out.println(set[i] +" "+(j + 1));
					}
				}
			}
		}finally{
			if(scan != null)scan.close();
		}
	}
}