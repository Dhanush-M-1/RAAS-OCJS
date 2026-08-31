import java.util.Scanner;

class Main {

public static void main(String[] args) {
Scanner inp = new Scanner(System.in);

while (true) {
int h = inp.nextInt();
int w = inp.nextInt();
if (h == 0 && w == 0)
break;
else if (h >= 1 && w <= 300) {

for(int i = 0; i < h; i++) {
for(int j = 0; j < w; j++) {
if(i % 2 == 0){
if(j % 2 == 0)
System.out.print('#');
else
System.out.print('.');
}
else{
if(j % 2 == 0)
System.out.print('.');
else
System.out.print('#');
}
}
System.out.println();
}

System.out.println();
}
}

}
}
