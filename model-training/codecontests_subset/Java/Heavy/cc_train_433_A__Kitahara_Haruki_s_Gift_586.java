import java.io.*;

public class Apple {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        int n = 0;
        int w[];
        int weight = 100;
        
        //n
        String s = new String(in.readLine());
        n = Integer.parseInt(s);
        
        //w[]
        w = new int[n];
        s = new String(in.readLine());
        int space_num = 0;
        int tmp = 0;
        while(true){
        	int num = s.indexOf(" ", space_num);
        	if(num == -1){
        		String w_s = s.substring(space_num);
            	w[tmp] = Integer.parseInt(w_s);
        		break;
        	}
        	String w_s = s.substring(space_num, num);
        	w[tmp] = Integer.parseInt(w_s);
        	tmp++;
        	space_num = num + 1;
        }
        
        //sort
        java.util.Arrays.sort(w);
                
        //divide
        int Fuyuma = w[n-1];
        int Setuna = 0;
        for(int i = n-2;i >= 0;i--){
        	if(Fuyuma > Setuna){
        		Setuna += w[i];
        	}
        	else{
        		Fuyuma += w[i];
        	}
        }
        
        //output
        if(Fuyuma == Setuna){
        	System.out.println("YES");
        }
        else{
        	System.out.println("NO");
        }
    }
}