
import java.util.*;
public class file{
public static void main(String[] args){
Scanner scan = new Scanner(System.in);
int n=scan.nextInt();
scan.nextLine();
String str=scan.nextLine();
int e=0;
for(int i=0;i<str.length();i++){
if(str.charAt(i) == '8'){
e++;
}
}
int ans = n/11 >e?e:n/11;
System.out.println(ans);
}
}