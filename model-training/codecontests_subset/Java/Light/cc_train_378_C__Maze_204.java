    import java.util.*; 
    public class ProblemC_Maze{
     
            static 	Scanner SC = new Scanner(System.in);
    		static int n;
    		static int m;
    		static int k;
    		static boolean[][] visted;
    		static char[][] A;
          
    	public static void main(String [] args){
    			
    			n = SC.nextInt(); 
    			m = SC.nextInt();
    			k = SC.nextInt();
    			visted = new boolean[509][509];
    			A = new char[509][509];
    			 
    			for(int i = 0 ; i < n ; i++){
    				String s = SC.next();
    				for(int j = 0 ; j < m ; j++){
    					A[i][j] = s.charAt(j);
    				}
    			}
    			for(int i = 0 ; i < n ; i++){
    				boolean flag = false;
    				for(int j = 0 ; j < m ; j++){
    					if(A[i][j] == '.'){
    						dfs(i, j);
    						flag = true;
    						break;
    					}
    				}
    				if(flag)
    					break;
    			}
    			for(int i = 0 ; i < n ; i++){
    				for(int j = 0 ; j < m ; j++){
    					System.out.printf("%c", A[i][j]);
    				}
    				System.out.printf("\n");
    			}
     
    	}
    	static void dfs(int i, int j){
    		if( i < 0 || j < 0 || i >= n || j >= m)
    			return;
    		if(visted[i][j])
    		 return;
    		if(A[i][j] != '.')
    		return;
    		
    		visted[i][j] = true;
    		dfs(i+1, j);
    		dfs(i, j+1);
    		dfs(i-1, j);
    		dfs(i, j-1);
    		if(k != 0){
    			A[i][j] = 'X';
    			k--;
    		}
    	}
    }