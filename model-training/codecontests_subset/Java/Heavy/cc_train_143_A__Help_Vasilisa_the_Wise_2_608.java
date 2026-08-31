import java.util.Scanner;


public class TaskA {

    

    public void run(){
        Scanner sc = new Scanner(System.in);
        int r1= sc.nextInt();
        int r2=sc.nextInt();
        int c1=sc.nextInt();
        int c2= sc.nextInt();
        int d1= sc.nextInt();
        int d2= sc.nextInt();
        
        for (int i=1;i<10;i++){
            for (int j=1;j<10;j++){
                if (i==j || (i+j != r1) ) continue;
                for (int k=1;k<10;k++){
                    if (k==i || k==j || (i+k != c1) || (j+k != d2 ) ) continue;
                    for (int l=1;l<10;l++){
                        if (l==i || l==j || l==k) continue;
                        if ((i+k == c1) && (j+l ==c2)
                        && (i+l == d1) && (k+j == d2) 
                        && (i+j == r1) && (k+l == r2)){
                            System.out.println(i+" "+ j);
                            System.out.println(k+" "+ l);
                            return;
                        }
                    }
                    
                }
            }
        }
        System.out.println("-1");
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        new TaskA().run();

    }

}
