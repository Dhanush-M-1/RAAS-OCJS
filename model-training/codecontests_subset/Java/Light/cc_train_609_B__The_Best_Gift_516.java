import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TheBestGift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] input1=   Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
		int n= input1[0];
		int m =input1[1];
		
		ArrayList<Integer> books = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++){
			books.add(scan.nextInt());
			
		}
		Collections.sort(books);
		
		ArrayList<Integer> countGenreBook = new ArrayList<Integer>();
		for(int i=0;i<m;i++){
			countGenreBook.add(i, 0);
		}
		//ArrayList<Integer> genrebook= new  ArrayList<Integer>();
		int tmpbook= 0;
		int mi=-1;
		for(int i=0;i<n;i++){
			if(tmpbook!=books.get(i)){
				tmpbook=books.get(i);
				mi++;
				countGenreBook.set(mi,1);
				
			}else{
				countGenreBook.set(mi,countGenreBook.get(mi)+1);
			}
		}
		int count=n,result=0;
		

		for(int j=0;j<m;j++){
			
			result+=(count-countGenreBook.get(j))*countGenreBook.get(j);
			count=count-countGenreBook.get(j);
			if(count<0) break;
		}
		System.out.println(result);
	}

}
