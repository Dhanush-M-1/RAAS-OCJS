import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int anInt = sc.nextInt();
        for (int zzz = 0; zzz < anInt; zzz++) {
            int len = sc.nextInt();
            char[][]chars = new char[len][len];
            for (int i = 0; i < len; i++) {
                chars[i] = sc.next().toCharArray();
            }
            int invert;
            if(chars[0][1] == chars[1][0]){
                invert = 0;
                if(chars[len - 1][len - 2] == chars[0][1])
                    invert++;
                if(chars[len - 2][len - 1] == chars[0][1])
                    invert++;
                System.out.println(invert);
                if(chars[len - 1][len - 2] == chars[0][1]){
                    System.out.println(len + " " + (len - 1));
                }
                if(chars[len - 2][len - 1] == chars[0][1]){
                    System.out.println((len - 1) + " " + len);
                }
            }else if(chars[len - 1][len - 2] == chars[len - 2][len - 1]){
                invert = 0;
                if(chars[len - 1][len - 2] == chars[0][1])
                    invert++;
                if(chars[len - 2][len - 1] == chars[1][0])
                    invert++;
                System.out.println(invert);
                if(chars[0][1] == chars[len - 1][len - 2]){
                    System.out.println("1 2");
                }else if(chars[1][0] == chars[len - 1][len - 2]){
                    System.out.println("2 1");
                }
            }else{
                System.out.println(2);
                  if(chars[0][1] == chars[len - 1][len - 2]){
                    System.out.println("1 2");
                      System.out.println((len - 1) + " " + len);
                }else{
                    System.out.println("1 2");
                    System.out.println(len + " " + (len - 1));
                }
            }
        }
    }
}
// 1 0 1 0