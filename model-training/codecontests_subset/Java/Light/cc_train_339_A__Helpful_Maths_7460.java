import java.util.*;
public class ladder4_5{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String[] numbers = s.split("\\+");
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length;i++){
            if(i!= numbers.length-1)
                System.out.print(numbers[i]+"+");
            else
                System.out.print(numbers[i]);
        }
    }

}