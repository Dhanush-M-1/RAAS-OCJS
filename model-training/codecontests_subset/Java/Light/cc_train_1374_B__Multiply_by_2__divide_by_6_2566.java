public class S{
    public static void main(String[]a){
        var in = new java.util.Scanner(System.in);
        int T = in.nextInt();
        
        outer:
        for(int t=0;t<T;t++){
            int n = in.nextInt();
            int c = 0;
            
            while(n!=1){
            	if(n%6==0)
            		n /= 6;
            	else if(n%3==0){
            		n *= 2;
            	}else{
            		break;
            	}
            	c++;
            }
            if(n==1)
            	System.out.println(c);
            else System.out.println(-1);
        }
    }
}
