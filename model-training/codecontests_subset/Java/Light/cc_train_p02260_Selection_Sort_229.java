import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int N = sc.nextInt(),x,y,count = 0;
    int[] n = new int[N];
    
    for(int i = 0; i < N; i++)
    	n[i] = sc.nextInt();
    
    for(int i = 0; i < N; i++){
    	x = i;
    	for(int j = i; j < N; j++){
    		if(n[j] < n[x])
    			x = j;
    	}
    		
    	if(i != x){
    		y = n[i];
    		n[i] = n[x];
    		n[x] = y;
    		count++;
    	}	
    }
    for(int i = 0; i < N; i++)
    	if(i != N - 1)
    		System.out.print(n[i] + " ");
    	else
    		System.out.println(n[i]);
    
    System.out.println(count);
    
    sc.close();
  }
}