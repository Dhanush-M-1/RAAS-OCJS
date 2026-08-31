import java.io.*;
import java.util.*;
public class cf3032C{
    public static void main(String[] args) throws IOException {
    	Scanner f = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(f.nextLine());
        int n = Integer.parseInt(st.nextToken())+1;
        int[] loc = new int[n+1];
        loc[n] = 1000000000 * 2 + 1;
        int[] h = new int[n];
        for(int i = 1; i < n; i++){
        	st = new StringTokenizer(f.nextLine());
        	loc[i] = Integer.parseInt(st.nextToken());
        	h[i] = Integer.parseInt(st.nextToken());
        }
        f.close();
        
        int[] trees = new int[n];
        trees[0] = 0;
        int occprev = 0;
        trees[1] = 1;//knock first tree to the left
        int occ = loc[1];
        occprev = Math.max(occprev, occ);
        int one, two, newocc1, newocc2;
        for(int i = 2; i < n; i++){
        	if(occprev < loc[i] - h[i]){//tree i falls left
        		one = trees[i-2] + 1;
        		newocc1 = loc[i];
        	}
        	else if(loc[i+1] > loc[i] + h[i]){//tree i falls right
        		one = trees[i-2] + 1;
        		newocc1 = loc[i] + h[i];
        	}
        	else{//no fall
        		one = trees[i-2];
        		newocc1 = loc[i];
        	}
        	
        	if(occ < loc[i] - h[i]){//tree i falls left
        		two = trees[i-1] + 1;
        		newocc2 = loc[i];
        	}
        	else if(loc[i+1] > loc[i] + h[i]){//tree i falls right
        		two = trees[i-1] + 1;
        		newocc2 = loc[i] + h[i];
        	}
        	else{//no fall
        		two = trees[i-1];
        		newocc2 = loc[i];
        	}
        	
        	occprev = occ;
        	if(one < two || (one == two && newocc1 > newocc2)){
        		occ = newocc2;
        		trees[i] = two;
        	}
        	else{//one > two || (one == two && newocc1 <= newocc2)
        		occ = newocc1;
        		trees[i] = one;
        	}
        	occprev = Math.max(occprev, loc[i]);
        }
        
        System.out.println(trees[n-1]);
    }
}