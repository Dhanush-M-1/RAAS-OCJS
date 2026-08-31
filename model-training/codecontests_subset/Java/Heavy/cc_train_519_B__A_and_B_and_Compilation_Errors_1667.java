import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in); 
		int noOfErrors = sc.nextInt(); 
		
		Map<Integer,Integer> initialErrors = new HashMap<Integer,Integer>(noOfErrors);
		Map<Integer,Integer> firstError = new HashMap<Integer,Integer>(noOfErrors-1);
		Map<Integer,Integer> secondError = new HashMap<Integer,Integer>(noOfErrors-2);
		
		int errorLineNumber = 0;
		for(int i=0; i< noOfErrors ; i++) 
		{
			errorLineNumber = sc.nextInt();
			initialErrors.put(errorLineNumber, initialErrors.get( errorLineNumber ) == null ? 1 : initialErrors.get(errorLineNumber)+1 );
		}
		
		for(int i=0; i< noOfErrors-1 ; i++) {
			errorLineNumber = sc.nextInt();
			firstError.put(errorLineNumber, firstError.get( errorLineNumber ) == null ? 1 : firstError.get(errorLineNumber)+1 );
		}

		for(int i=0; i< noOfErrors-2 ; i++) {
			errorLineNumber = sc.nextInt();
			secondError.put(errorLineNumber, secondError.get( errorLineNumber ) == null ? 1 : secondError.get(errorLineNumber )+1 );
		}
		
		Set<Entry<Integer, Integer>> entrySet = initialErrors.entrySet();
		Iterator<Entry<Integer, Integer>> iteratorset = entrySet.iterator();
		while( iteratorset.hasNext() ) 
		{
			Entry<Integer, Integer> next = iteratorset.next();
			if( firstError.get(next.getKey()) == null) 
				System.out.println( next.getKey() );
			else if(firstError.get(next.getKey()) < initialErrors.get(next.getKey()))
				 System.out.println(next.getKey());
		}
		
		entrySet = firstError.entrySet();
		iteratorset = entrySet.iterator();
		
		while( iteratorset.hasNext() ) 
		{
			Entry<Integer, Integer> next = iteratorset.next();
			if( secondError.get(next.getKey()) == null) 
				System.out.println( next.getKey() );
			else if(secondError.get(next.getKey()) < firstError.get(next.getKey()))
				 System.out.println(next.getKey());
		}
		sc.close();
	}
}
