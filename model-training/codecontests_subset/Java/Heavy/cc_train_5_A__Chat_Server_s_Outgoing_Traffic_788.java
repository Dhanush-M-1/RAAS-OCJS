import java.util.*;
public class Main{
   public static void main(String[] args) {
      Scanner reader = new Scanner(System.in);  
      int sum = 0;
      int index=-4;
      int many =0;
      while(reader.hasNext()){
      String comando = reader.nextLine();
      if(comando.charAt(0)=='+')
      {
      many+=1;
      }else{
          if(comando.charAt(0)=='-'){
          many-=1;
          }
      }
      String past[];
      index = comando.indexOf(":");
      if(index!=-1){
      past = comando.split(":");
      if(index!=comando.length()-1){
      sum+=(past[1].length())*many;
      }
      }
     }
     System.out.println(sum);
    }
}