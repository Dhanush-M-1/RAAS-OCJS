import java.util.*;
public class ks {

 public static void main(String[] args) {
  Scanner no=new Scanner(System.in);
  int t=no.nextInt();
  for(int i=0;i<t;i++){
    int n=no.nextInt();
    char arr[][]=new char[n][n];
    int ans=0;
    for(int j=0;j<n;j++){
      String s=no.next();
      arr[j]=s.toCharArray();
    }
    if(arr[n-2][n-1]=='0'&&arr[n-1][n-2]=='0'){
      if(arr[0][1]=='0'){
        ans++;
      }
      if(arr[1][0]=='0'){
        ans++;
      }
    }
    else if(arr[n-2][n-1]=='1'&&arr[n-1][n-2]=='1'){
      if(arr[0][1]=='1'){
        ans++;
      }
      if(arr[1][0]=='1'){
        ans++;
      }
    }
    else if(arr[n-2][n-1]=='1'&&arr[n-1][n-2]=='0'){
      ans++;
      if(arr[0][1]=='1'&&arr[1][0]=='1'){
        //ans++;
      }
      else if(arr[0][1]=='1'&&arr[1][0]=='0'){
        ans++;
      }
      else if(arr[0][1]=='0'&&arr[1][0]=='0'){
        //ans++;
      }
      else if(arr[0][1]=='0'&&arr[1][0]=='1'){
        ans++;
      }
    }
    else if(arr[n-2][n-1]=='0'&&arr[n-1][n-2]=='1'){
      ans++;
      if(arr[0][1]=='1'&&arr[1][0]=='1'){
       // ans++;
      }
      else if(arr[0][1]=='1'&&arr[1][0]=='0'){
        ans++;
      }
      else if(arr[0][1]=='0'&&arr[1][0]=='0'){
       // ans++;
      }
      else if(arr[0][1]=='0'&&arr[1][0]=='1'){
        ans++;
      }
    }
    if(arr[n-2][n-1]=='0'&&arr[n-1][n-2]=='0'){
      System.out.println(ans);
      if(arr[0][1]=='0'){
        System.out.println(1+" "+2);
      }
      if(arr[1][0]=='0'){
        System.out.println(2+" "+1);
      }
    }
    else if(arr[n-2][n-1]=='1'&&arr[n-1][n-2]=='1'){
     System.out.println(ans);
      if(arr[0][1]=='1'){
        System.out.println(1+" "+2);
      }
      if(arr[1][0]=='1'){
        System.out.println(2+" "+1);
      }
    }
    else if(arr[n-2][n-1]=='1'&&arr[n-1][n-2]=='0'){
     // arr[n-1][n-2]='1';
     // ans++;
     System.out.println(ans);
      if(arr[0][1]=='1'&&arr[1][0]=='1'){
        System.out.println((n-1)+" "+n);
      }
      else if(arr[0][1]=='1'&&arr[1][0]=='0'){
        System.out.println((n-1)+" "+n);
        System.out.println(2+" "+1);
      }
      else if(arr[0][1]=='0'&&arr[1][0]=='0'){
        System.out.println(n+" "+(n-1));
      }
      else if(arr[0][1]=='0'&&arr[1][0]=='1'){
        System.out.println((n-1)+" "+n);
        System.out.println(1+" "+2);
      }
    }
    else if(arr[n-2][n-1]=='0'&&arr[n-1][n-2]=='1'){
      System.out.println(ans);
      if(arr[0][1]=='1'&&arr[1][0]=='1'){
        System.out.println((n)+" "+(n-1));
      }
      else if(arr[0][1]=='1'&&arr[1][0]=='0'){
        System.out.println((n-1)+" "+n);
        System.out.println(1+" "+2);
      }
      else if(arr[0][1]=='0'&&arr[1][0]=='0'){
        System.out.println((n-1)+" "+(n));
      }
      else if(arr[0][1]=='0'&&arr[1][0]=='1'){
        System.out.println((n-1)+" "+n);
        System.out.println(2+" "+1);
      }
    }
  }
 }

}



