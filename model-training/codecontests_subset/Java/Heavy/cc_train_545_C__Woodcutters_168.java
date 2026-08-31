import java.util.Scanner;
import java.util.Arrays;

public class WoodCutters{
	
	public static class tree implements Comparable<tree>{
	
		int coor;
		int height;
		
		public tree(int c, int h){
		
			coor = c;
			height = h;
		}
		
		public int compareTo(tree other){
			
			return this.coor - other.coor;
		
		}
		
		public String toString(){
		    return Integer.toString(coor);
		}
	}
	
	
	public static void main(String[] args){
	
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int i;
		
		if(n == 1 || n == 2)
		    System.out.println(n);
		else{
    		
    		int d, result = 2;
    		tree[] list = new tree[n];
    		
    		for(i=0; i<n; i++){
    		    list[i] = new tree(input.nextInt(), input.nextInt());
    		}
    		
    		Arrays.sort(list);
    		d = list[0].coor;
    	
    	    for(i=1; i<n-1; i++){
    	        
    	        if(list[i].coor - d >list[i].height){
    	            result++;
    	            d = list[i].coor;
    	        }
    	        else if(list[i+1].coor - list[i].coor > list[i].height){
    	                result++;
    	                d = list[i].coor + list[i].height;
    	            }
    	            else
    	                d = list[i].coor;
    	   
    	    }
    	    
    	    System.out.println(result);
		}
	
	}
	
	
	
	
	
}