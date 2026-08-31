import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner cin = new Scanner(new BufferedInputStream(System.in));
        while (cin.hasNext()) {
            int number=cin.nextInt();
            int[] weight=new int[number];
            int total=0,twoCount=0,oneCount=0;
            for(int i=0;i<number;i++)
            {
                weight[i]=cin.nextInt();
                total+=weight[i];
                if(weight[i]==100){
                    oneCount++;
                }
                else if(weight[i]==200){
                    twoCount++;
                }
            }
            if(total%200!=0){
                System.out.println("NO");
            }
            else{
                int temp=total/200;
                int j=0;
                int flag=0;
                for(int i=temp;i>=0;){
                    if(oneCount>=i&&twoCount>=j){
                        flag=1;
                        System.out.println("YES");
                        break;
                    }
                    i=i-2;
                    j++;
                }
                if(flag==0){
                    System.out.print("NO");
                }
            
            }
            
        }
    }

}
