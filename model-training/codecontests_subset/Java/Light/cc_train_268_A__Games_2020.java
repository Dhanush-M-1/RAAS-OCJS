import java.util.Scanner;
public class Transportation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] team = new int[n][2];
		int output=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<2;j++){
				team[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++)
				if(team[i][0]==team[j][1]) output++;
			for(int j=i+1;j<n;j++)
				if(team[i][1]==team[j][0]) output++;
		}
	     
	     System.out.println(output);
	}
}

//이차원배열로 각 팀당 홈,게스트유니폼 저장
//다른팀과 비교 

