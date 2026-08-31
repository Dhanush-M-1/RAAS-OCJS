import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        String line;
        
        String keyence = "keyence";
        String s = "";
        
        ArrayList<Integer> n = new ArrayList<Integer>();
        
        for(int i = 0; cin.hasNext(); i++){
	        line = cin.nextLine();
	        
	        if(i == 0) {
	            s = line;
	            
	        } else {
	            
	        }
	        
        }
        
        
        
        String res = "NO";
        
        if(s.equals(keyence)) {
            res = "YES";
        }
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j < s.length(); j++) {
                if((s.substring(0, i) + s.substring(j, s.length())).equals(keyence)) {
                    res = "YES";
                    
                }
            }
        }
        
        System.out.println(res);
        
    }
    
}
