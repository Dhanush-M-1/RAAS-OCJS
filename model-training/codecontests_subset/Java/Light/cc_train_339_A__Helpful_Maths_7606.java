import java.util.*;
import java.lang.*;
import java.io.*;
public class A_Helpful_Maths{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String word = sc.next();
    String ans="";
    int countOne = 0, countTwo = 0, countTree = 0;
   if(word.length()==1){
       sout(word);
   }else{
    for(int i=0;i<word.length();i++){
        if(word.charAt(i)=='1')
        countOne++;
        else if(word.charAt(i)=='2')
        countTwo++;
        else if(word.charAt(i)=='3')
        countTree++;
    }

    for(int i=0;i<countOne;i++){
        ans+="1+";
    }
    for(int i=0;i<countTwo;i++){
        ans+="2+";
    }
    for(int i=0;i<countTree;i++){
        ans+="3+";
    }
    sout(ans.substring(0,ans.length()-1)); 
   }

}
private static void sout(String s){
    System.out.print(s);
}

private static void sout(int i){
    System.out.println(i);
}

    private static void sout(double i){
    System.out.println(i);
}
}