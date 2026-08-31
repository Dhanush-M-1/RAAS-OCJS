import java.util.*;
public class file{
public static void main(String[] args){
Scanner scan=new Scanner(System.in);
int n=scan.nextInt();
scan.nextLine();
String str=scan.nextLine();
char[] ch=new char[str.length()];
int ind=0;
for(char c:str.toCharArray()){
ch[ind++]=c;
}
boolean flag=true;
for(int i=1;i<str.length();i++){
if(ch[i]-ch[i-1] <0){
System.out.println("YES");
System.out.println(i+" "+(i+1));
flag=false;
break;
}
}
if(flag){
System.out.println("NO");

}
}
}