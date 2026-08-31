import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        String num = in.next();

        char[] numArr = num.toCharArray();
        int leng = numArr.length;
        int count = 0;
        if(numArr[leng-y-1] == '0'){
//            System.out.println("Change index " + (leng-y-1) + " to 1");
            count++;
        }
        for(int i = leng-y;i<leng;i++){
            if(numArr[i] == '1'){
  //              System.out.println("Change index " + i + " to 0");
                count++;
            }
        }

        for(int i = leng-x;i<leng-y-1;i++){
            if(numArr[i] == '1'){
    //            System.out.println("Change index " + i + " to 0");
                count++;
            }
        }
        System.out.println(count);
    }
}

