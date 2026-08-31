import java.util.*;

public class Main {
	static int students, voteVal, minPossible, firstSum, secndSum, valueOf_K;
	static ArrayList<Integer> votes = new ArrayList<Integer>();
	
	static int getSum() {
		int sum = 0;
		for(int i = 0; i < students; i++) {
			sum += (int)votes.get(i);
		}
		return sum;
	}
	static int forWinSum(int max_k) {
		int sum = 0;
		for(int i = 0; i < students; i++) {
			sum+= (max_k - (int)votes.get(i));
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		students = inp.nextInt();
		for(int i = 0; i < students; i++) {
			voteVal = inp.nextInt();
			votes.add(voteVal);
		}
		minPossible = (int)Collections.max(votes);
		
		firstSum = getSum();
		secndSum = forWinSum(minPossible);
		if(secndSum > firstSum) {
			valueOf_K = minPossible;
		} else {
			while(secndSum <= firstSum) {
				minPossible++;
				secndSum = forWinSum(minPossible);
				if(secndSum > firstSum) {
					valueOf_K = minPossible;
				}
			}
		}
		
		System.out.println(valueOf_K);
		
	
	}
}
