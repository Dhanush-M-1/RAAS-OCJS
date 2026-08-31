import java.util.*;
public class Main{
public static void main(String[] args){
Scanner sc = new Scanner(System.in);
String s;
int a = Integer.parseInt(sc.next());
int b = Integer.parseInt(sc.next());
if(a%2==0||b%2==0){
s = "Even";
}else{
s = "Odd";
}
System.out.println(s);

}
}