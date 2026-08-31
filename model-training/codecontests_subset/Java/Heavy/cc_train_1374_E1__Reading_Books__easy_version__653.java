import java.util.*;
import java.io.*;
public class R653E2{
   public static void main(String[] main) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      PrintWriter out = new PrintWriter(System.out);
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      TreeSet<Book> total = new TreeSet<Book>();
      TreeSet<Book>[][] types = new TreeSet[2][2];
      types[0][0] = new TreeSet<Book>();
      types[0][1] = new TreeSet<Book>();
      types[1][0] = new TreeSet<Book>();
      types[1][1] = new TreeSet<Book>();
      for(int i = 0; i < n; i++) {
    	  st = new StringTokenizer(br.readLine());
    	  int t = Integer.parseInt(st.nextToken());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          Book temp = new Book(t, a, b, i+1);
          total.add(temp);
          types[a][b].add(temp);
      }
      int t1 = types[1][1].size();
      int t01 = types[0][1].size();
      int t10 = types[1][0].size();
      if(t1 + Math.min(t01,t10) < k || 2*k-t1 > m)
    	  out.println(-1);
      else {
	      TreeSet<Book> read = new TreeSet<Book>();
	      TreeSet<Book>[][] readtypes = new TreeSet[2][2];
	      readtypes[0][0] = new TreeSet<Book>();
	      readtypes[0][1] = new TreeSet<Book>();
	      readtypes[1][0] = new TreeSet<Book>();
	      readtypes[1][1] = new TreeSet<Book>();
	      int minsum = 0;
	      for(int i = 0; i < Math.min(k, t1); i++) {
	    	  Book temp = types[1][1].pollFirst();
	    	  read.add(temp);
	    	  readtypes[1][1].add(temp);
	    	  total.remove(temp);
	    	  minsum += temp.getT();
	      }
	      for(int i = 0; i < k - Math.min(k, t1); i++) {
	    	  Book temp = types[0][1].pollFirst();
	    	  read.add(temp);
	    	  readtypes[0][1].add(temp);
	    	  total.remove(temp);
	    	  minsum += temp.getT();
	    	  temp = types[1][0].pollFirst();
	    	  read.add(temp);
	    	  readtypes[1][0].add(temp);
	    	  total.remove(temp);
	    	  minsum += temp.getT();
	      }
	      for(int i = 0; i < m-2*k+Math.min(k,t1); i++) {
	    	  Book temp = total.pollFirst();
	    	  read.add(temp);
	    	  int a = temp.getA();
	    	  int b = temp.getB();
	    	  readtypes[a][b].add(temp);
	    	  types[a][b].remove(temp);
	    	  minsum += temp.getT();
	      }
	      int num11 = Math.min(k, t1);
	      int currsum = minsum;
	      while(readtypes[1][1].size() > 0) {
	    	  Book temp;
	    	  Book temp1 = readtypes[1][1].pollLast();
	    	  read.remove(temp1);
	    	  total.add(temp1);
	    	  types[1][1].add(temp1);
	    	  if(k - readtypes[1][1].size() > readtypes[0][1].size() && k - readtypes[1][1].size() > readtypes[1][0].size()) {
	    		  temp = types[0][1].pollFirst();
	    		  if(temp == null)
	    			  break;
		    	  read.add(temp);
		    	  readtypes[0][1].add(temp);
		    	  total.remove(temp);
		    	  currsum += temp.getT();
		    	  temp = types[1][0].pollFirst();
		    	  if(temp == null)
		    		  break;
		    	  read.add(temp);
		    	  readtypes[1][0].add(temp);
		    	  total.remove(temp);
		    	  currsum += temp.getT();
		    	  temp = readtypes[0][0].pollLast();
		    	  if(temp == null)
		    		  break;
		    	  read.remove(temp);
		    	  currsum -= temp.getT();
		    	  total.add(temp);
		    	  types[0][0].add(temp);
	    	  }
	    	  else if(k - readtypes[1][1].size() > readtypes[0][1].size()) {
	    		  temp = types[0][1].pollFirst();
	    		  if(temp == null)
	    			  break;
		    	  read.add(temp);
		    	  readtypes[0][1].add(temp);
		    	  total.remove(temp);
		    	  currsum += temp.getT();
	    	  }
	    	  else if(k - readtypes[1][1].size() > readtypes[1][0].size()) {
	    		  temp = types[1][0].pollFirst();
	    		  if(temp == null)
	    			  break;
		    	  read.add(temp);
		    	  readtypes[1][0].add(temp);
		    	  total.remove(temp);
		    	  currsum += temp.getT();
	    	  }
	    	  else {
	    		  temp = total.pollFirst();
	    		  read.add(temp);
		    	  int a = temp.getA();
		    	  int b = temp.getB();
		    	  readtypes[a][b].add(temp);
		    	  types[a][b].remove(temp);
		    	  currsum += temp.getT();
		    	  if(a == 1 && b == 1)
		    		  break;
	    	  }
	    	  currsum -= temp1.getT();
	    	  if(minsum > currsum) {
	    		  num11 = readtypes[1][1].size();
	    		  minsum = currsum;
	    	  }
	      }
	      out.println(minsum);
	      StringJoiner sj = new StringJoiner(" ");
	      if(num11 != readtypes[1][1].size()) {
	    	  for(Book temp: read) {
	    		  total.add(temp);
		    	  int a = temp.getA();
		    	  int b = temp.getB();
		    	  types[a][b].add(temp);
	    	  }
		      read = new TreeSet<Book>();
		      for(int i = 0; i < num11; i++) {
		    	  Book temp = types[1][1].pollFirst();
		    	  read.add(temp);
		    	  total.remove(temp);
		    	  minsum += temp.getT();
		      }
		      for(int i = 0; i < k - num11; i++) {
		    	  Book temp = types[0][1].pollFirst();
		    	  read.add(temp);
		    	  total.remove(temp);
		    	  minsum += temp.getT();
		    	  temp = types[1][0].pollFirst();
		    	  read.add(temp);
		    	  total.remove(temp);
		    	  minsum += temp.getT();
		      }
		      for(int i = 0; i < m-2*k+num11; i++) {
		    	  Book temp = total.pollFirst();
		    	  read.add(temp);
		    	  int a = temp.getA();
		    	  int b = temp.getB();
		    	  types[a][b].remove(temp);
		    	  minsum += temp.getT();
		      }
	      }
	      for(Book b: read) {
	    	  sj.add(Integer.toString(b.getIndex()));
	      }
	      out.println(sj);
      }
      out.close();
   }
}
class Book implements Comparable<Book>{
	private int time;
	private int alice;
	private int bob;
	private int index;
	public Book(int t, int a, int b, int i) {
		time = t;
		alice = a;
		bob = b;
		index = i;
	}
	public int getT() {
		return time;
	}
	public int getA() {
		return alice;
	}
	public int getB() {
		return bob;
	}
	public int compareTo(Book b) {
		if(time == b.getT())
			return index - b.getIndex();
		return time-b.getT();
	}
	public int getIndex() {
		return index;
	}
}