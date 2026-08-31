import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        for(int j=0;j<n;j++){
            int count=0;
            int q[]=new int[3];
            for(int i=0;i<3;i++){
                q[i]=scan.nextInt(); 
            }
            if(q[1]==0){
                System.out.println("0");
                continue;
            }    
            if(q[2]>=2&&q[1]>=1){
                int e=q[2]/2;
                while(true){
                    if(q[1]>=e){
                        count+=e;
                        q[1]-=e;
                        q[2]-=(2*e);
                        break;
                    }
                    e--;
                }
            }
            if(q[1]>=2&&q[0]>=1){
                int e=q[1]/2;
                while(true){
                    if(q[0]>=e){
                        count+=e;
                        q[0]-=e;
                        q[1]-=(2*e);
                        break;
                    }
                    e--;
                }
            }
            System.out.println(count*3);
        }
    }   
}