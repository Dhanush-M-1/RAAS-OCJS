import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
	public static void main(String[] args)throws Exception {
		InputStreamReader is = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader (is);
		String []input = br.readLine().split("");
		Main m = new Main();
		stack st = m.new stack();
		for(String s: input) {
			st.push(s);
			if(st.getSize() > 1) {
				String temp = st.pop()+ st.pop();
				if(!"TS".equals(temp)) {
					st.push(temp.substring(1,2));
					st.push(temp.substring(0,1));
				}
			}
		}
		System.out.println(st.getSize());
	}
	public class stack{
		private ArrayList<String> stackList;
		private int count;
		stack(){
			stackList = new ArrayList<String>();
			count = 0;
		}
		public String pop() {
			String s = stackList.get(count-1);
			stackList.remove(count-1);
			count--;
			return s;
		}
		public void push(String s) {
			stackList.add(s);
			count++;
		}
		public int getSize() {
			return count;
		}
	}
}