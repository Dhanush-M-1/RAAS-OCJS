                           /* Rajkin Hossain */
import java.io.*;
import java.util.*;

public class C {

    //static FastInput k = new FastInput("/home/rajkin/Desktop/input.txt");
    static FastInput k = new FastInput(System.in);
    static FastOutput z = new FastOutput();
    static Treap treap;
    static int n, s;
    static int [] y;
    
    static void startAlgorithm() {
    	int mid = n/2;
    	if(s == y[mid]){
    		z.println(0);
    	}
    	else if(s > y[mid]) {
    		treap.floor(s);
    		int nextIndex = treap.getIndex(treap.floorValue);
    		long sum = 0;
    		while(nextIndex != mid){
    			sum += Math.abs(y[nextIndex] - s);
    			nextIndex--;
    		}
    		
    		sum += Math.abs(y[nextIndex] - s);
    		
    		z.println(sum);
    	}
    	else{
    		treap.ceil(s);
    		int prevIndex = treap.getIndex(treap.ceilValue);
    		long sum = 0;
    		while(prevIndex != mid){
    			sum += Math.abs(y[prevIndex] - s);
    			prevIndex++;
    		}
    		
    		sum += Math.abs(y[prevIndex] - s);
    		
    		z.println(sum);
    	}
    }
    
	public static void main(String [] args) throws FileNotFoundException {        
		while(k.hasNext()) {
			n = k.nextInt();
			s = k.nextInt();
			treap = new Treap();
			
			y = new int[n];
			
			for(int i = 0; i<n; i++){
				int value = k.nextInt();
				treap.insert(value);
				y[i] = value;
			}
			
			Arrays.sort(y);
			
			startAlgorithm();
        }
		
        z.flush();
        System.exit(0);
	}
	
	static class Treap {
		Node root;
		
		int length;
		long g_seed;
		int ans;
		
		long lowerValue, higherValue;
		long ceilValue, floorValue;
		
		public Treap(){
			g_seed = 1l;
			length = 0;
			ans = 0;
			
			lowerValue = higherValue = -1l;
			ceilValue = floorValue = -1l;
		}
		
		long fastrand() { 
			g_seed = (214013 * g_seed + 2531011);
			
			return (g_seed>>16)&0x7FFF;
		} 
		
		int getSize(Node cursor){
			if(cursor == null) return 0;
			int leftSubTreeSize = cursor.left != null ? cursor.left.size : 0;
			int rightSubTreeSize = cursor.right != null ? cursor.right.size : 0;
			
			return 1 + leftSubTreeSize + rightSubTreeSize;
		}
		
		void insert(long value){
			root = insert(root, value);
			root.size = 1 + getSize(root.left) + getSize(root.right);
			
			length++;
		}
		
		Node rotateRight(Node cursor){
			Node returedNode = cursor.left;
			
			Node z = cursor.left.right;
			cursor.left.right = cursor;
			cursor.left = z;
			
			return returedNode;
		}
		
		Node rotateLeft(Node cursor){
			Node returedNode = cursor.right;
			
			Node z = cursor.right.left;
			cursor.right.left = cursor;
			cursor.right = z;
			
			return returedNode;
		}
		
		Node insert(Node cursor, long value){
			if(cursor == null) {
				return new Node(value);
			}
			
			if(value < cursor.value){
				cursor.left = insert(cursor.left, value);
				
				if(cursor.left.priority > cursor.priority){
					cursor = rotateRight(cursor);
				}
			}
			else{
				cursor.right = insert(cursor.right, value);
				
				if(cursor.right.priority > cursor.priority){
					cursor = rotateLeft(cursor);
				}
			}
			
			if(cursor.left != null) cursor.left.size = getSize(cursor.left);
			if(cursor.right != null) cursor.right.size = getSize(cursor.right);
			
			cursor.size = getSize(cursor);
			
			return cursor;
		}
		
		void higher(Node cursor, long key){
			if(cursor == null) return;
			
			if(key < cursor.value){
				higherValue = cursor.value;
				higher(cursor.left, key);
			}
			else{
				higher(cursor.right, key);
			}
		}
		
		void higher(long key){
			higherValue = -1l;
			higher(root, key);
		}
		
		void ceil(Node cursor, long key){
			if(cursor == null) return;
			
			if(key < cursor.value){
				ceilValue = cursor.value;
				ceil(cursor.left, key);
			}
			else if(key == cursor.value){
				ceilValue = cursor.value;
			}
			else{
				ceil(cursor.right, key);
			}
		}
		
		void ceil(long key){
			ceilValue = -1l;
			ceil(root, key);
		}
		
		void floor(Node cursor, long key){
			if(cursor == null) return;
			
			if(key > cursor.value){
				floorValue = cursor.value;
				floor(cursor.right, key);
			}
			else if(key == cursor.value){
				floorValue = cursor.value;
			}
			else{
				floor(cursor.left, key);
			}
		}
		
		void floor(long key){
			floorValue = -1l;
			floor(root, key);
		}
		
		void lower(Node cursor, long key){
			if(cursor == null) return;
			
			if(key > cursor.value){
				lowerValue = cursor.value;
				lower(cursor.right, key);
			}
			else{
				lower(cursor.left, key);
			}
		}
		
		void lower(long key){
			lowerValue = -1l;
			lower(root, key);
		}
		
		int getIndex(Node cursor, long key){
			if(cursor == null) return Integer.MIN_VALUE;
			if(cursor.value == key) return getSize(cursor.left);
			
			if(key > cursor.value){
				return getSize(cursor.left) + 1 + getIndex(cursor.right, key);
			}
			else{
				return getIndex(cursor.left, key);
			}
		}
		
		int getIndex(long key){
			return getIndex(root, key);
		}
		
		int found(Node cursor, long initial, long key){
			if(initial - cursor.value < key){
				if(cursor.left != null){
					return found(cursor.left, initial, key);
				}
				else if(cursor.right != null){
					return found(cursor.right, initial, key);
				}
				else{
					return length - getIndex(cursor.value);
				}
			}
			else if(cursor.right != null){
				return found(cursor.right, initial, key);
			}
			
			return 0;
		}
		
		int found(long initial, long key){
			ans = 0;
			if(root == null) return 0;
			return found(root, initial, key);
		}
		
		int orderOf(long key){ // less than key
			return orderOf(root, key);
		}
		
		int orderOf(Node cursor, long key){ // less than key
			if(cursor == null) return 0;
			else if(cursor.value < key) return getSize(cursor.left) + 1 + orderOf(cursor.right, key);
			else return orderOf(cursor.left, key);
		}
		
	    void print(Node root) {
	        if (root == null)
	            return;
	        print(root.left);
	        System.out.println(root.value);
	        print(root.right);
	    }
		
		class Node {
			long priority;
			long value;
			int size;
			
			Node left, right;
			public Node(long value){
				this.value = value;
				this.priority = fastrand();
			}
		}
	}
	
    /* MARK: FastInput and FastOutput implementation */
	 
    public static class FastInput {
        BufferedReader reader;
        StringTokenizer tokenizer;
 
        public FastInput(InputStream stream){
        	reader = new BufferedReader(new InputStreamReader(stream));
        }
        
	    public FastInput(String path){
	        try {
	        	reader = new BufferedReader(new FileReader(path));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        tokenizer = null;
	    }
 
        public String next() {
            return nextToken();
        }
        
        public String nextLine() {
            try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return null;
        }
 
        public boolean hasNext(){
            try {
                return reader.ready();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return false;
        }
 
        public String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = null;
                try {
                    line = reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }
 
        public Integer nextInt() {
            return Integer.parseInt(nextToken());
        }
       
        public Long nextLong() {
            return Long.valueOf(nextToken());
        }
    	
    	public void inputIntegerList(ArrayList<Integer> list, int size) {
    		for(int i = 0; i<size; i++) {
    			list.add(nextInt());
    		}
    	}
    	
    	public void inputLongList(ArrayList<Long> list, int size) {
    		for(int i = 0; i<size; i++) {
    			list.add(nextLong());
    		}
    	}
    	
    	public void inputWordList(ArrayList<String> list, int size) {
    		for(int i = 0; i<size; i++) {
    			list.add(next());
    		}
    	}
    	
    	public void inputLineList(ArrayList<String> list, int size) {
    		for(int i = 0; i<size; i++) {
    			list.add(nextLine());
    		}
    	}
    	
    	public void inputIntegerArray(int [] array, int size) {
    		for(int i = 0; i<size; i++) {
    			array[i] = nextInt();
    		}
    	}

    	public void inputLongArray(long [] array, int size) {
    		for(int i = 0; i<size; i++) {
    			array[i] = nextLong();
    		}
    	}
    	
    	public void inputWordArray(String [] array, int size) {
    		for(int i = 0; i<size; i++) {
    			array[i] = next();
    		}
    	}
    	
    	public void inputLineArray(String [] array, int size) {
    		for(int i = 0; i<size; i++) {
    			array[i] = nextLine();
    		}
    	}
    }
 
    public static class FastOutput extends PrintWriter {
    	public FastOutput() { 
            super(new BufferedOutputStream(System.out)); 
    	}
    	
    	public void printSideBySideSet(Set<Object> set, int size) {
    		boolean isFirstElementPrinted = false;
    		for(Object element : set) {
    			if(!isFirstElementPrinted) {
    				print(element);
    				isFirstElementPrinted = true;
    				
    				return;
    			}
    			print(" "+element);
    		}
    		println();
    	}
    	
    	public void printLineByLineSet(Set<Object> set, int size) {
    		for(Object element : set) {
    			println(element);
    		}
    	}
    	
    	public void printSideBySideList(ArrayList<Object> list, int size) {
    		print(list.get(0));
    		for(int i = 1; i<size; i++) {
    			print(" "+list.get(i));
    		}
    		println();
    	}
    	
    	public void printLineByLineList(ArrayList<Object> list, int size) {
    		for(int i = 0; i<size; i++) {
    			println(list.get(i));
    		}
    	}
    	
    	public void printSideBySideArray(Object [] array, int size) {
    		print(array[0]);
    		for(int i = 1; i<size; i++) {
    			print(" "+array[i]);
    		}
    		println();
    	}
    	
    	public void printLineByLineArray(Object [] array, int size) {
    		for(int i = 0; i<size; i++) {
    			println(array[i]);
    		}
    	}
    }
}