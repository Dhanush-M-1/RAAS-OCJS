import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            while(sc.hasNext()) {
                int n = sc.nextInt();
                if(n == 0)break;
                
                String f = "";
                int right = 0;
                int left = 0;
                int cnt = 0;
                int step = 0;
                for(int i=1;i<=n;i++) {
                	 f = sc.next();
	                 if(f.equals("lu")) {
	               		 left += 1;
	               		 step++;
	               	 }
	               	 else if(f.equals("ru")) {
	               		 right += 1;
	               		 step++;
	               	 }
	               	 else if(f.equals("ld")) {
	               		 left -= 1;
	               		 step--;
	               	 }
	               	 else {
	               		 right -= 1;
	               		 step--;
	               	 }
	               	 if(left==right && step==2 || step==-2) {
	               		 cnt++;
	               		 step = 0;
	               	 }
                }
                System.out.println(cnt);
            }
        }
    }
}



