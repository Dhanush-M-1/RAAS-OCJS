import java.util.*;

public class a385{
        public static void main(String[] args){
                Scanner sc = new Scanner(System.in);
                int  n = sc.nextInt();
                int c = sc.nextInt();
                int[] costcutting = new int[n-1];
                int previouscost = sc.nextInt();
                for(int i=1;i<n;i++){
                        int todaycost = sc.nextInt();
                        costcutting[i-1] = previouscost-todaycost;
                        previouscost = todaycost;
                }

                int maxindex = getMaxValue(costcutting);
                if(costcutting[maxindex]-c>0){
                        System.out.println(costcutting[maxindex]-c);
                }else{
                        System.out.println(0);
                }

        }

public static int getMaxValue(int[] numbers){
    int maxValue = numbers[0];
        int j=0;
    for(int i=1;i<numbers.length;i++){
        if(numbers[i] > maxValue){
            maxValue = numbers[i];
                j=i;
        }
    }
    return j;
}

}
