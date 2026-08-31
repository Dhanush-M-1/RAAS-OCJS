import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int list[] = new int[52];
		String mark = " ";
		int num = 0;
		for(int i = 0;i < n;i++){
			mark = sc.next();
			num = sc.nextInt();
			switch(mark){
			case "S":
				list[num-1] = 1;
				break;
			case "H":
				list[num + 12] = 1;
				break;
			case "C":
				list[num + 25] = 1;
				break;
			case "D":
				list[num + 38] = 1;
				break;
			}
		}
		for(int j = 0;j < 52;j++){
			if(1 != list[j]){
				if(j >= 0 && j < 13){
					mark = "S";
					num = j + 1;
				}else if(j > 12 && j < 26){
					mark = "H";
					num = j - 12;
				}else if(j > 25 && j < 39){
					mark = "C";
					num = j - 25;
				}else{
					mark = "D";
					num = j - 38;
				}
				System.out.println(mark + " " + num);
			}
		}
	}
}
