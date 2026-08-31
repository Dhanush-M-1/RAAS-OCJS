import java.util.Scanner;
/*
 * @author zezo
 * date : Jan 26, 2014
 */
public class BearandRaspberry {
    public static void main(String[] args)throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int c=scanner.nextInt();
        int []days=new int [n];
        for(int i=0 ; i<n;i++){
            int day = scanner.nextInt();
            days[i]=day;
        }
//        if(c==0){
//            System.out.println("0");
//        }
//        else {
        
        if(n==1){
            if((days[0]-c)<=0){
                System.out.println("0");
            }
            else {
            System.out.println(days[0]-c);
            }
        }
        else if(n==2){
            if((days[0]-days[1]-c)<=0){
                System.out.println("0");
            }
            else {
            System.out.println(days[0]-days[1]-c);
            }
        }
        else {
            int MAX []=new int [n-1];
        for (int i=0;i<n-2;i++){
            if((days[i]-days[i+1]) > days[i+1]-days[i+2]){
                MAX[i]=days[i]-days[i+1];
            }
            else {
                MAX[i]=days[i+1]-days[i+2];
            }
        }
        java.util.Arrays.sort(MAX);
        int max=MAX[n-2];
        if((max-c)<=0){
            System.out.println("0");
        }
        else{
        System.out.println(max-c);
        }
        }
    
    }
}
