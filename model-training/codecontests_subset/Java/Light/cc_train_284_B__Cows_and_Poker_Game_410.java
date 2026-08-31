import java.util.*;
public class Main{
public static void main(String... args){
Scanner sc = new Scanner(System.in);
int n = sc.nextInt(); sc.nextLine();
String s = sc.nextLine();

int a = 0;
int f = 0;
int i = 0;
for (char ch : s.toCharArray()){
  if (ch=='A')a++;
  if (ch=='F')f++;
  if (ch=='I')i++;
}
if (i>=2){System.out.println(0);System.exit(0);}
if (i==1){System.out.println(1);System.exit(0);}
System.out.println(a);
}
}