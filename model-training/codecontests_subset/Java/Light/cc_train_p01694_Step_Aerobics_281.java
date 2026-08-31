import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);




		while(true){
			int n = sc.nextInt();
			if (n==0){
				break;
			}

			int count = 0;
			String rightFoot = "d"; // d?????¨????????????
			String leftFoot = "d";
			String command = "x";
			String nextFoot = "x";
			String nextMove = "x";
			String beforeStat = "d"; // false???????????°??????
			
			for(int i=0;i<n;i++){
				command=sc.next();

				nextFoot=command.toString().substring(0,1);
				nextMove=command.toString().substring(1,2);

				if(nextFoot.equals("r") && nextMove.equals("u")){
					rightFoot = "u";
				}
				else if(nextFoot.equals("r") && nextMove.equals("d")){
					rightFoot = "d";
				}
				else if(nextFoot.equals("l") && nextMove.equals("u")){
					leftFoot = "u";
				}
				else if(nextFoot.equals("l") && nextMove.equals("d")){
					leftFoot ="d";
				}

				if(rightFoot==leftFoot&&(!rightFoot.equals(beforeStat))){
					// ????¶???¨????¶????????????????????????????????????¶?????¨??°????????´???
					count ++;
					if(beforeStat=="d"){
						beforeStat="u";
					}
					else{
						beforeStat="d";
					}
				}
			}
			System.out.println(count);

		}
	}

}