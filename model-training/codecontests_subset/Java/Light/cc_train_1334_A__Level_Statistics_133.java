import java.util.*;

public class Main{
//public class P85A{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		int test = scan.nextInt();

		while(test>0){
			int prevP = 0;
			int prevC = 0;

			int n = scan.nextInt();

			int nextP = 0;
			int nextC = 0;

			boolean flag = true;

			for(int i=0; i<n; i++){
				nextP = scan.nextInt();
				nextC = scan.nextInt();

				if(flag){
					if(nextP<prevP)
						flag = false;
					else if(nextC<prevC)
						flag = false;
					else if(true){
						int diffPlays = nextP - prevP;
						int diffClears = nextC - prevC;
						if(diffPlays<diffClears)
							flag = false;
					}
				}

				prevP = nextP;
				prevC = nextC;
			}

			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");

			test--;

		}



	}
}