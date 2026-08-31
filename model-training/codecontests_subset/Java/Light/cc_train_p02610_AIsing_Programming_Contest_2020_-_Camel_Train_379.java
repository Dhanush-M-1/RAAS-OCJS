import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
		    int n = sc.nextInt();
		    ArrayList<Unit> front = new ArrayList<>();
		    ArrayList<Unit> rear = new ArrayList<>();
		    for (int j = 0; j < n; j++) {
		        Unit u = new Unit(sc.nextInt(), sc.nextInt(), sc.nextInt());
		        if (u.isPos()) {
		            front.add(u);
		        } else {
		            rear.add(u);
		        }
		    }
	        Unit.type = 1;
	        Collections.sort(front);
	        Unit.type = 2;
	        PriorityQueue<Unit> left = new PriorityQueue<>();
	        long sum = 0;
	        for (Unit u : front) {
	            left.add(u);
	            sum += u.left;
	            if (left.size() > u.idx) {
	                Unit x = left.poll();
	                sum -= x.left - x.right;
	            }
	        }
	        Unit.type = 3;
	        Collections.sort(rear);
	        Unit.type = 4;
	        PriorityQueue<Unit> right = new PriorityQueue<>();
	        for (Unit u : rear) {
	            right.add(u);
	            sum += u.right;
	            if (right.size() > n - u.idx) {
	                Unit x = right.poll();
	                sum -= x.right - x.left;
	            }
	        }
	        sb.append(sum).append("\n");
		}
		System.out.print(sb);
	}
	
	static class Unit implements Comparable<Unit> {
	    static int type;
	    int idx;
	    int left;
	    int right;
	    
	    public Unit(int idx, int left, int right) {
	        this.idx = idx;
	        this.left = left;
	        this.right = right;
	    }
	    
	    public int compareTo(Unit another) {
	        if (type == 1) {
	            return idx - another.idx;
	        } else if (type == 3) {
	            return another.idx - idx;
	        } else if (type == 2) {
	            return left - right - (another.left - another.right);
	        } else {
	            return right - left - (another.right - another.left);
	        }
	    }
	    
	    public boolean isPos() {
	        return left >= right;
	    }
	}
}
