import java.util.*;

public class Example {

    public static void main(String[] args) {
        new Example().solve();;
    }
    
    public void solve() {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	int m = sc.nextInt();
    	String command;
    	int i;
    	int mem[] = new int[m];
		int tmp[] = new int[m];		
		boolean found = false;
		int size,cur,free = 0, id = 1, eid;
    	while(t>0) {
    		t--;    		
    		command = sc.next();
    		//System.out.println(Arrays.toString(mem));
    		if(command.equals("alloc")) {
    			size = sc.nextInt();
    			found = false;
    			free = 0;
    			for(i=0;i<m;i++){
    				if(mem[i] != 0) {
    					free = 0;
    				}
    				else {
    					free++;
    				}
    				
    				if(free >= size) { //check
    					found = true;
    					for(int j=i-size+1;j<=i;j++) {
    						mem[j] = id;
    					}
    					
    					System.out.println(id++);
    					break;
    				}
    				
    			}
    			
    			if(!found) {
    				System.out.println("NULL");
    			}
    			
    		}
    		else if(command.equals("erase")) {
    			eid = sc.nextInt();
    			found = false;
    			for(int j=0;j<m;j++){
    				if(eid > 0 && mem[j] == eid) {
    					found = true;
    					mem[j] = 0;   					
    				}
    			}
    			if(!found) {
    				System.out.println("ILLEGAL_ERASE_ARGUMENT");
    			}    			    			
    		}
    		else {
    			int delta = 0;
    			for(int j=0;j<m;j++) {
    				if(mem[j] > 0) {
    					mem[j-delta] = mem[j];
    				}
    				else {
    					delta++;
    				}
    			}
    			
    			for(int j=m-delta;j<m;j++) {
    				mem[j] = 0;
    			}    			
    		}
    	}
    	
    }
    
}