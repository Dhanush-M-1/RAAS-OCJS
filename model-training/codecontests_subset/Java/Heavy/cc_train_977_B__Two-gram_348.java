    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.*;
     
    public class contest {
    	
    	public static void main(String[] args) throws IOException {
    		Scanner sc = new Scanner(System.in);
    		PrintWriter pw = new PrintWriter(System.out);
    		int n = sc.nextInt();
    		String s = sc.next();
    		TreeMap<String,Integer> tr = new TreeMap<String, Integer>();
    		for(int i=0;i<s.length()-1;i++) {
    			String tmp = s.charAt(i)+""+s.charAt(i+1);
    			if(!tr.containsKey(tmp))
    				tr.put(tmp, 0);
    			tr.put(tmp, tr.get(tmp)+1);
    		}
    		String a = tr.firstKey();
    		int c = tr.pollFirstEntry().getValue();
    		while(!tr.isEmpty()) {
    			int c1 = tr.firstEntry().getValue();
    			String t = tr.pollFirstEntry().getKey();
    			if(c1>c){
    				c = c1;
    				a = t;
    			}
    		}
    		pw.println(a);
    		pw.flush();
    		pw.close();
    	}
    }