import java.util.*;
import java.io.*;
public class R653E1{
   public static void main(String[] main) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      PrintWriter out = new PrintWriter(System.out);
      int n = Integer.parseInt(st.nextToken());
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
      if(types[1][1].size() + Math.min(types[0][1].size(),types[1][0].size()) < k)
    	  out.println(-1);
      else {
	      TreeSet<Book> read = new TreeSet<Book>();
	      TreeSet<Book>[][] readtypes = new TreeSet[2][2];
	      readtypes[0][0] = new TreeSet<Book>();
	      readtypes[0][1] = new TreeSet<Book>();
	      readtypes[1][0] = new TreeSet<Book>();
	      readtypes[1][1] = new TreeSet<Book>();
	      int minsum = 0;
	      int t1 = types[1][1].size();
	      int t01 = types[0][1].size();
	      int t10 = types[1][0].size();
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
	      int currsum = minsum;
	      for(int i = Math.min(k, t1); i > Math.max(0,k - Math.min(t01,t10)); i--) {
	    	  Book temp = readtypes[1][1].pollLast();
	    	  read.remove(temp);
	    	  currsum -= temp.getT();
	    	  if(k - readtypes[1][1].size() > readtypes[0][1].size() && k - readtypes[1][1].size() > readtypes[1][0].size()) {
	    		  temp = types[0][1].pollFirst();
		    	  read.add(temp);
		    	  readtypes[0][1].add(temp);
		    	  total.remove(temp);
		    	  currsum += temp.getT();
		    	  temp = types[1][0].pollFirst();
		    	  read.add(temp);
		    	  readtypes[1][0].add(temp);
		    	  total.remove(temp);
		    	  currsum += temp.getT();
	    	  }
	    	  else if(k - readtypes[1][1].size() > readtypes[0][1].size()) {
	    		  temp = types[0][1].pollFirst();
		    	  read.add(temp);
		    	  readtypes[0][1].add(temp);
		    	  total.remove(temp);
		    	  currsum += temp.getT();
	    	  }
	    	  else if(k - readtypes[1][1].size() > readtypes[1][0].size()) {
	    		  temp = types[1][0].pollFirst();
		    	  read.add(temp);
		    	  readtypes[1][0].add(temp);
		    	  total.remove(temp);
		    	  currsum += temp.getT();
	    	  }
	    	  if(minsum > currsum) {
	    		  minsum = currsum;
	    	  }
	      }
	      out.println(minsum);
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