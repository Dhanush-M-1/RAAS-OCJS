import java.util.Scanner;
public class TTV{
public static void main(String[]ags){
Scanner i = new Scanner(System.in);
int a = i.nextInt();
int b = i.nextInt();
 int sum =0;

while(a > 0){
if(a>=b){
sum += b;
a -= b-1;
}
else{
    sum +=a;
a = 0;
    }
}
System.out.println(sum);


}

}