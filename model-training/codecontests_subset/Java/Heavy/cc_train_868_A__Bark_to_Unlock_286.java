import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class main {
	
	public static class MyScanner {
	      BufferedReader br;
	      StringTokenizer st;
	 
	      public MyScanner() {
	         br = new BufferedReader(new InputStreamReader(System.in));
	      }
	 
	      String next() {
	          while (st == null || !st.hasMoreElements()) {
	              try {
	                  st = new StringTokenizer(br.readLine());
	              } catch (IOException e) {
	                  e.printStackTrace();
	              }
	          }
	          return st.nextToken();
	      }
	 
	      int nextInt() {
	          return Integer.parseInt(next());
	      }
	      
	      void nextArrayInt(int[] array,int n){
	    	  
	    	  try {
				st = new StringTokenizer(br.readLine());
	    	  } catch (IOException e) { }
	    	  
	    	  for(int a=0;a<n;a++){
	    		  array[a] = Integer.parseInt(st.nextToken());
	    	  }
	    	  
	      }
	 
	      long nextLong() {
	          return Long.parseLong(next());
	      }
	 
	      double nextDouble() {
	          return Double.parseDouble(next());
	      }
	 
	      String nextLine(){
	          String str = "";
		  try {
		     str = br.readLine();
		  } catch (IOException e) {
		     e.printStackTrace();
		  }
		  return str;
	      }

	   }
	/* quick sort */
	static int partition(int arr[], int left, int right){
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	      return i;
	}
	 
	static void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	}
	/* quick sort */
	
	static boolean binarySearch(int[] data,int key){
		int low = 0;
		int high = data.length - 1;
		while(high >= low) {
           int middle = (low + high) / 2;
             if(data[middle] == key) {
                 return true;
             }
             if(data[middle] < key) {
                 low = middle + 1;
             }
             if(data[middle] > key) {
                 high = middle - 1;
             }
        }
        return false;
   }
	
	static String random(){
		Random r = new Random();
		String answ = "";
		
		for(int b=0;b<6;b++){
			int a = r.nextInt(150)+50;
			answ += (char)a;
		}
		
		return answ;
	}
	
	public static void main(String[] args){
		MyScanner sc = new MyScanner();
		
		char[] pass = sc.nextLine().toCharArray();
		int n= sc.nextInt();
		
		char[][] allwords = new char[n][2];
		
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		
		for(int a=0;a<n;a++){
			allwords[a] = sc.nextLine().toCharArray();
		}
		
		for(int a=0;a<n;a++){
			if(pass[0]==allwords[a][1]) first.add(a);
			if(pass[0] == allwords[a][0]&&pass[1]== allwords[a][1]){
				first.add(a);
				second.add(a);
			}
		}
		for(int a=0;a<n;a++){
			if(pass[1]==allwords[a][0]) second.add(a);
		}
		
		//int min = first.size()>second.size()?second.size():first.size();
		if(first.size()>second.size()){
			String temp = "";
			for(int a=0;a<second.size();a++){
				for(int b=0;b<first.size();b++){
					temp = allwords[first.get(b)]+""+allwords[second.get(a)];
				}
				//System.out.println(temp);
				if(temp.equals(pass)){
					System.out.println("YES");
					return;
				}
			}
		}else{
			if(first.size()==0){
				System.out.println("NO");
				return;
			}else{
				String temp = "";
				for(int a=0;a<first.size();a++){
					for(int b=0;b<second.size();b++){
						temp = allwords[second.get(b)][0]+allwords[second.get(b)][1]+""+allwords[first.get(a)][0]+allwords[first.get(a)][1];
					}
					//System.out.println(temp);
					if(temp.equals(pass)){
						System.out.println("YES");
						return;
					}
				}
			}
		}
		if(!first.isEmpty()&&!second.isEmpty()){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		/*System.out.println(first);
		System.out.println(second);*/
	}
}