import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[][] uniforms = new int[n][2];
        
        for(int i=0; i<n; i++){
            uniforms[i][0] = sc.nextInt();
            uniforms[i][1] = sc.nextInt();
        }
        
        int count = 0;
        
        for(int i=0; i<n; i++){
            int homeUniform = uniforms[i][0];
            
            for(int j=0;j < n; j++){
                if(j != i){
                    if(homeUniform == uniforms[j][1]){
                        count++;    
                    }
                }
            }
        }
        
        System.out.println(count);
    }
}