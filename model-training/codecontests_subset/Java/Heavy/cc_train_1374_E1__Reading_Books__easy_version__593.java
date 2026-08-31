import java.io.*;
import java.util.*;

public class ans5{
	static class Book{
		int time;
		int alice;
		int bob;
		Book(int t, int a, int b){
			time=t;
			alice=a;
			bob=b;
		}
		@Override
		public String toString(){
			return Integer.toString(time)+" "+Integer.toString(alice)+" "+Integer.toString(bob);
		}
	}
	static class srt implements Comparator<Book>{
		@Override
		public int compare(Book a, Book b){
			if (a.time!=b.time) {
				return a.time-b.time;
			}
			else{
				if(a.alice==1 && a.bob==1 && b.alice==1 && b.bob==1)
					return 0;
				if(a.alice==1 && a.bob==1)
					return -1;
				else if (b.alice==1 && b.bob==1)
					return 1;
				else
					return 0;
			}

		}
	}
	static class srt_ulta implements Comparator<Book>{
		@Override
		public int compare(Book a, Book b){
			if (a.time!=b.time) {
				return b.time-a.time;
			}
			else{
				if(a.alice==1 && a.bob==1 && b.alice==1 && b.bob==1)
					return 0;
				if(a.alice==1 && a.bob==1)
					return 1;
				else if (b.alice==1 && b.bob==1)
					return -1;
				else
					return 0;
			}

		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] s=br.readLine().trim().split("\\s+");
		int n=Integer.parseInt(s[0].trim());
		int k=Integer.parseInt(s[1].trim());
		Book[] bookArr=new Book[n];
		for (int i=0; i<n; ++i) {
			s=br.readLine().trim().split("\\s+");
			Book b = new Book(Integer.parseInt(s[0].trim()),Integer.parseInt(s[1].trim()),Integer.parseInt(s[2].trim()));
			bookArr[i]=b;
		}
		Arrays.sort(bookArr, new srt());
		ArrayList<Book> both=new ArrayList<Book>();
		ArrayList<Book> alice=new ArrayList<Book>();
		ArrayList<Book> bob=new ArrayList<Book>();
		for (int i=0; i<n; ++i) {
			if (bookArr[i].alice==1 && bookArr[i].bob==1) {
				both.add(bookArr[i]);
			}
			else if(bookArr[i].alice==1 && bookArr[i].bob==0) {
				alice.add(bookArr[i]);
			}
			else if(bookArr[i].alice==0 && bookArr[i].bob==1) {
				bob.add(bookArr[i]);
			}
		}		
		if (both.size()+alice.size()<k ||both.size()+bob.size()<k) {
			System.out.println(-1);
		}
		else{
			int kalice=0;
			int kbob=0;
			int kboth=0;
			int sum=0;
			while(kalice<alice.size() && kbob<bob.size() && kboth<both.size() && (kalice+kbob)/2+kboth<k){
				if (alice.get(kalice).time+bob.get(kbob).time<both.get(kboth).time) {
					sum+=alice.get(kalice).time+bob.get(kbob).time;
					++kalice;
					++kbob;
				}
				else{
					sum+=both.get(kboth).time;
					++kboth;
				}
			}
			if ((kalice+kbob)/2+kboth<k) {
				if (kalice<alice.size() && kbob<bob.size() && kboth>=both.size()) {
					while(kalice<alice.size() && kbob<bob.size() && (kalice+kbob)/2+kboth<k){
						sum+=alice.get(kalice).time+bob.get(kbob).time;
						++kalice;
						++kbob;		
					}
				}
				else if(kboth<both.size()){
					while(kboth<both.size() && (kalice+kbob)/2+kboth<k){
						sum+=both.get(kboth).time;
						++kboth;
					}
				}
				
			}
			
			System.out.println(sum);
		}

		// for (int i=0; i<n; ++i) {
		// 	System.out.println(bookArr[i]);
		// }

	// 	ArrayList<Book> used=new ArrayList<Book>();
	// 	int b=0,a=0,sum=0;
	// 	for (int i=0;i<n ;++i ) {
	// 		Book temp=bookArr[i];
	// 		if (temp.alice==0 && temp.bob==0) 
	// 			continue;
	// 		int btemp=b+temp.bob;
	// 		int atemp=a+temp.alice;
	// 		if (Math.abs(btemp-atemp)<=1) {
	// 			a=atemp;
	// 			b=btemp;
	// 			sum+=temp.time;
	// 			used.add(temp);
	// 		}
	// 		if (a>=k && b>=k) {
	// 			break;
	// 		}
	// 	}

	// 	if (a<k || b<k) {
	// 		System.out.println(-1);
	// 	}
	// 	else if(a==k && b==k){
	// 		System.out.println(sum);
	// 	}
	// 	else{
	// 		Collections.sort(used, new srt_ulta());
	// 		if (a>b) {
	// 			for (Book temp : used ) {
	// 				if (a==b) 		
	// 					break;
	// 				if (temp.alice==1 && temp.bob==0) {
	// 					sum-=temp.time;
	// 				}
	// 			}	
	// 		}
	// 		else if(b>a){
	// 			for (Book temp : used ) {
	// 				if (a==b) 		
	// 					break;
	// 				if (temp.alice==0 && temp.bob==1) {
	// 					sum-=temp.time;
	// 				}
	// 			}	
	// 		}
	// 		System.out.println(sum);
	// 	}
	}
}