import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;


public class New_Year_Book_Reading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
	    int n = in.nextInt(), m = in.nextInt();
	    
	    int[] books = new int[n], days = new int[m];
	    
	    for(int i = 0; i<n; i++) books[i] = in.nextInt();
	    
	    for(int i = 0; i<m; i++) days[i] = in.nextInt()-1;
	    
	    ArrayList<Integer> read = new ArrayList<Integer>();
	    
	    long res = 0;
	    
	    for(int i = 0; i<m; i++){
	        HashSet<Integer> ba2i = new HashSet<Integer>();
	        for(int j = read.size() - 1; j >= 0; j--)
	        {
	            if(read.get(j) == days[i]) break;
	            ba2i.add(read.get(j));
	        }
	        for(int x: ba2i) res += books[x];
	        read.add(days[i]);
	    }
	    System.out.println(res);

}
}