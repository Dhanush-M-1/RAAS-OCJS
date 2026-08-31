import java.util.*;

public class Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int n= scan.nextInt();
		
		Map<Integer,Integer> first = new HashMap<Integer,Integer>();
		Map<Integer,Integer> second = new HashMap<Integer,Integer>();
		Map<Integer,Integer> third = new HashMap<Integer,Integer>();
		
		for(int i = 0; i < n; i++){
			int key = scan.nextInt();
			if(!first.containsKey(key)){
				first.put(key, 0);
			}
			first.put(key, first.get(key) + 1);
		}
		
		for(int i = 0; i < n -1; i++){
			int key = scan.nextInt();
			if(!second.containsKey(key)){
				second.put(key, 0);
			}
			second.put(key, second.get(key) + 1);
		}
		
		for(int i = 0; i < n -2; i++){
			int key = scan.nextInt();
			if(!third.containsKey(key)){
				third.put(key, 0);
			}
			third.put(key, third.get(key) + 1);
		}
		

		int a = 0; int b = 0;
		
		Iterator it = first.entrySet().iterator();
		while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        
	        if(!second.containsKey(pair.getKey())){
				a = (int) pair.getKey(); break;
			}
	        else if(first.get(  pair.getKey()) > second.get( pair.getKey())){  
	        	a = (int) pair.getKey(); break;
	        }

		}

		Iterator it1 = second.entrySet().iterator();
		while (it1.hasNext()) {
	        Map.Entry pair = (Map.Entry)it1.next();
	      
	        if(!third.containsKey(pair.getKey())){
	        	b = (int) pair.getKey(); break;
			}
	        if(second.get(pair.getKey()) > third.get(pair.getKey()) ){
	        	b = (int)pair.getKey(); break;
	        	
	        }
		}
		
		System.out.println(a);
		System.out.println(b);
	}

}
