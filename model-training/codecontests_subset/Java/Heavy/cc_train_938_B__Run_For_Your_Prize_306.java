import java.util.Scanner;

public class Pizza938B {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n,i,count,count1,count2;
        int[] arr = new int[100002];
        while (input.hasNext()){
            count=0;count1=0;count2=0;
            n = input.nextInt();
            for(i=0;i<n;i++){
                arr[i] = input.nextInt();
                if(arr[i]<500000.5)
                    count=arr[i]-1;
                else {
                    count1 = 1000000 - arr[i];
                    if(i==0){
                        count2=count1;
                    }
                    if(count2<count1)
                        count2=count1;
                }
            }
            if(count>=count2)
                System.out.println(count);
            else
                System.out.println(count2);
        }
    }
}
