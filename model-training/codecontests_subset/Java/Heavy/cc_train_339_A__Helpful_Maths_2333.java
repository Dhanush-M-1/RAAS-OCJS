import java.util.Arrays;
import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String str = sc.nextLine();
        String strRes="";
        int twoCnt=0,oneCnt=0,threeCnt=0;
        for (int i = 0; i < str.length(); i+=2) {
            if (str.charAt(i)=='1') {
                oneCnt++;
            }
            else if (str.charAt(i)=='2'){
                twoCnt++;
            }
            else if (str.charAt(i)=='3'){
                threeCnt++;
            }
        }
        for (int i = 0; i < oneCnt; i++) {
            strRes=strRes+'1';
            strRes=strRes+'+';
        }
        for (int i = oneCnt; i < twoCnt+oneCnt; i++) {
            strRes=strRes+'2';
            strRes=strRes+'+';
        }
        for (int i = twoCnt+oneCnt; i < threeCnt+oneCnt+twoCnt; i++) {
            strRes=strRes+'3';
            strRes=strRes+'+';
        }
        char[] res =strRes.toCharArray();
        for (int i = 0; i <res.length -1; i++) {
            System.out.print(res[i]);
        }
    }

}
