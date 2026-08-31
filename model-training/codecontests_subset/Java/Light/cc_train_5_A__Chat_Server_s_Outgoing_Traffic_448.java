import java.util.*;
import java.io.*;
import java.math.*;
public class Main{
public static void main(String... args)throws IOException{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int online = 0;
long total = 0;
while (true){
  String s = br.readLine();
  if (s==null) break;
  if (s.startsWith("+")){
    online++;
  } else if (s.startsWith("-")){
    online--;
  } else {
    String[] msg = s.split(":");
    if (msg.length==2)
    total+=online*msg[1].length();
  }
}
System.out.println(total);

}
}