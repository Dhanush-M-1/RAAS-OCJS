import java.util.*;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    
    int flag = 0;
    
    String s = sc.nextLine();
    int n = sc.nextInt();
    sc.nextLine();
    
    String[] a = new String[n];
    for(int i=0; i<n; i++){
     a[i] = sc.nextLine();
    }
    
    //Check if the word exists
    for(int i=0; i<n; i++){
      if(a[i].equals(s)){
      flag = 2;
      break;
      } 
    }
    if(flag!=2){
    //Check if the last letter exists
    for(int i=0; i<n; i++){
      if(a[i].charAt(1)==s.charAt(0)){
       flag++;
       break;
      }
    }
       //Check if the first letter exists after that
        for(int i=0; i<n; i++){
          if(a[i].charAt(0)==s.charAt(1)){
          flag++;
          break;
          }
         }
    }
    
    if(flag==2) System.out.println("YES");
    else System.out.println("NO");
    
  }
}