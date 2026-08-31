import java.util.Scanner;
public class sample{
	public static void main(String[] args){
	Task prog = new Task();
	prog.solve();
	}

	static class Task {
		public void solve() {
		    Scanner kbd = new Scanner(System.in);
		    String word = kbd.next();
		    int number = kbd.nextInt();
	            String[] words = new String[number];
	            for (int i = 0; i < number; ++i) {
	            	words[i] = kbd.next();
	            }
	            for (String x : words) {
	                for (String y : words) {
	                    if ((x + y).contains(word)) {
	                        System.out.println("YES");
	                        return;
	                    }
	                }
	            }
	            System.out.println("NO");
	        }
	
    }

}