import java.util.*;

public class Draco{
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int students = s.nextInt();
        int awrukVotes = 0;
        int elodreipVotes = 0;
        int[] votes = new int[students];
        int highest = 0;
        for(int i = 0; i < students; i++) {
        	votes[i] = s.nextInt();
        	if(votes[i] > highest) {
        		highest = votes[i];
        	}
        }
        for(int i = 0; i < students; i++) {
        	awrukVotes += highest - votes[i];
        	elodreipVotes += votes[i];
        }
        if(awrukVotes > elodreipVotes) {
        	System.out.println(highest);
        }
        else if(awrukVotes * students <= elodreipVotes || (awrukVotes == elodreipVotes)){
        	double temp = (elodreipVotes - awrukVotes) / (double) students;
        	int extraVotes = (int) Math.floor(temp);
        	System.out.println(highest + extraVotes + 1);
        }
        else {
        	double temp = (elodreipVotes - awrukVotes) / (double) students;
        	int extraVotes = (int) Math.ceil(temp);
        	if(awrukVotes + (students * extraVotes) == elodreipVotes) {
        		System.out.println(highest + extraVotes + 1);
        	}
        	else {
        	System.out.println(highest + extraVotes);
        	}
        	}
        s.close();
        }
}