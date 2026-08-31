// package Round_653;

import java.io.*;
import java.math.*;
import java.util.*;

public class Problem_E1 {  
    public static void main(String[] args) {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int numBooks = in.nextInt(), minLike = in.nextInt();
        ArrayList<Book> books = new ArrayList<Book>();
        
        for(int i = 0; i < numBooks; i++) {
        	books.add(new Book(in.nextInt(), in.nextInt(), in.nextInt()));
        }
        
        ArrayList<Book> aLike = new ArrayList<Book>();
        ArrayList<Book> bLike = new ArrayList<Book>();
        ArrayList<Book> bothLike = new ArrayList<Book>();
        
        Collections.sort(books, new SortA());
        for(int i = 0; i < books.size(); i++) {
        	Book next = books.get(i);
        	if(next.aLike != 1 || next.bLike == 1) {
        		break;
        	}
        	
        	aLike.add(next);
        	if(aLike.size() == minLike) {
        		break;
        	}
        }
        
        Collections.sort(books, new SortB());
        for(int i = 0; i < books.size(); i++) {
        	Book next = books.get(i);
        	if(next.bLike != 1 || next.aLike == 1) {
        		break;
        	}
        	
        	bLike.add(next);
        	if(bLike.size() == minLike) {
        		break;
        	}
        }
        
        int minLen = Math.min(aLike.size(), bLike.size());
        
        if(aLike.size() == minLen) {
        	while(bLike.size() > minLen) {
        		bLike.remove(bLike.size() - 1);
        	}
        }
        else {
        	while(aLike.size() > minLen) {
        		aLike.remove(aLike.size() - 1);
        	}
        }
        
        int taken = aLike.size() + bLike.size();
        
        Collections.sort(books, new SortS());
        for(int i = 0; i < books.size(); i++) {
        	Book next = books.get(i);
        	if(next.aLike == 0 || next.bLike == 0) {
        		break;
        	}
        	
        	if(taken == minLike * 2) {
        		if(aLike.size() == 0 || bLike.size() == 0) {
        			break;
        		}
        		
        		int rem = aLike.get(aLike.size() - 1).time + bLike.get(bLike.size() - 1).time;
        		
        		if(rem > next.time) {
					aLike.remove(aLike.size() - 1);
					bLike.remove(bLike.size() - 1);
					
					bothLike.add(next);
				}
        	}
        	else {
        		taken += 2;
        		bothLike.add(next);
        	}
        }
        
        if(taken != minLike * 2) {
        	out.println(-1);
        }
        else {
        	int time = 0;
        	for(Book b : aLike) {
        		time += b.time;
        	}
        	
        	for(Book b : bLike) {
        		time += b.time;
        	}
        	
        	for(Book b : bothLike) {
        		time += b.time;
        	}
        	out.println(time);
        }
        
        out.flush();
    }
    
    static class Book{
    	int time, aLike, bLike;
    	
    	public Book(int time, int a, int b) {
    		this.time = time;
    		aLike = a;
    		bLike = b;
    	}
    	
    	public String toString() {
    		return time + " " + aLike + " " + bLike;
    	}
    }
    
    static class SortTime implements Comparator<Book>{
		@Override
		public int compare(Book arg0, Book arg1) {
			return arg0.time - arg1.time;
		}
    }
    
    static class SortS implements Comparator<Book>{
		@Override
		public int compare(Book arg0, Book arg1) {
			int v1 = arg0.aLike == 1 && arg0.bLike == 1? 1 : 0;
			int v2 = arg1.aLike == 1 && arg1.bLike == 1? 1 : 0;
			if(v1 != v2) {
				return v2 - v1;
			}
			else {
				return arg0.time - arg1.time;
			}
		}
    }
    
    static class SortA implements Comparator<Book>{
		@Override
		public int compare(Book arg0, Book arg1) {
			int v1 = arg0.aLike == 1 && arg0.bLike == 0? 1 : 0;
			int v2 = arg1.aLike == 1 && arg1.bLike == 0? 1 : 0;
			if(v1 != v2) {
				return v2 - v1;
			}
			else {
				return arg0.time - arg1.time;
			}
		}
    }
    
    static class SortB implements Comparator<Book>{
		@Override
		public int compare(Book arg0, Book arg1) {
			int v1 = arg0.aLike == 0 && arg0.bLike == 1? 1 : 0;
			int v2 = arg1.aLike == 0 && arg1.bLike == 1? 1 : 0;
			if(v1 != v2) {
				return v2 - v1;
			}
			else {
				return arg0.time - arg1.time;
			}
		}
    }
    
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st;
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        }
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}
