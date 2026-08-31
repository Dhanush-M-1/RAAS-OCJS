import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class Masked{
	private static int[] permutatation ;
	private static boolean[] used;
	private static int[] binary;
	private static ArrayList<Integer> listString = new ArrayList<Integer>();
	private static HashSet<String> setInteger = new HashSet<String>();
	
	
	public static void main(String[] args){
		solveA();
	}
	
	private static void solveA(){
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[] list = new int[m];
		for(int i = 0 ; i < m ; i ++){
			list[i] = 0 ;
		}
		
		for(int i = 0 ; i  < n ; i++){
			int pp = scan.nextInt();
			for(int j = 0 ; j < pp ; j++){
				int t = scan.nextInt();
				list[t-1] = 1;
			}
		}
		
		for(int i = 0 ; i < m ; i++){
			if(list[i] == 0){
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	
	private static void generatePermutation(int n,int at){
		if(n == at){
			String answer= "";
			for(int i = 0 ;i < n ; i++){
				answer += permutatation[i];
			}
			setInteger.add(answer);
			System.out.println(answer);
		}else{
			for(int i = 0 ;i < n ; i++){
				if(!used[i]){
					used[i] = true;
					permutatation[at] = binary[i];
					//System.out.println("permutation[at]: "+permutatation[at]);
					generatePermutation(n, at+1);
					used[i] = false;
				}
			}
		}
	}

	private static class SegmentTree{
		
		
		private int[] tree;
		private int maxSize,height;
		
		
		private final int START = 0;
		private int EndIndex;
		private final int root=0;
	
		private int leftChild(int n){
			return 2*n+1;
		}
		
		private int rightChild(int n){
			return 2*n +2;
		}
		
		private int mid(int a,int b){
			return (a+b)/2;
		}
		
		public SegmentTree(int size){
			height =(int)( Math.ceil(Math.log(size)/Math.log(2)));
			maxSize = 2*(int)Math.pow(2,height)-1;
			tree = new int[maxSize];
			EndIndex = size-1;
		}
		
		
		private int getSum(int startIndex,int endIndex, int queryStart,int queryEnd,int current){
			if(queryStart <= startIndex && queryEnd >= endIndex){
				return tree[current];
			}
			if(endIndex < queryStart || startIndex > queryEnd ) return 0;
			
			int m = mid(startIndex,endIndex);
			
			return getSum(startIndex,m,queryStart,queryEnd,leftChild(current))+
					getSum(m+1,endIndex,queryStart,queryEnd,rightChild(current));
		}
		
		
		private int getSumUntil(int queryStart, int queryEnd){
			if(queryStart < 0 || queryEnd > EndIndex) return -1;
			return getSum(0,EndIndex,queryStart,queryEnd,root);
		}
		
		private int constructing(int[] elements,int start,int end,int current){
			if(start == end){
				tree[current] = elements[start]; 
				return tree[current];
			}
			int m = mid(start,end);
			tree[current] = constructing(elements,start,m,leftChild(current))+
					constructing(elements,m+1,end,rightChild(current));
			return tree[current];
		}
		
		private void ConstructSegmentTree(int[] elements){
			constructing(elements, 0,EndIndex,root);
		}
		
		
		public int[] getTree(){
			return tree;
		}
		
		
	}
	
}