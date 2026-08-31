import java.util.*;


public class bark {
	
	static String isThere(String[] arr , String key){
	    for(int i=0; i<arr.length; i++){
	        for(int j=i; j<arr.length; j++){
	            if((arr[i]+arr[j]).indexOf(key)!=-1 || (arr[j]+arr[i]).indexOf(key)!=-1)
	               return "YES";
	        }
	    }
	    return "NO";
	}

	
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		String key =in.next();
		int n = in.nextInt();
		String[] arr = new String[n];
		for(int i=0; i<n; i++){
		    arr[i]= in.next();
		}
		
		System.out.print(isThere(arr, key));
	}
	
	
}