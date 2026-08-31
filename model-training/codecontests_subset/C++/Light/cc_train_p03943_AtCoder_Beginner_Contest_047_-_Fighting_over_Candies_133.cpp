#include <iostream>
int main(){
  int A,B,C; std::cin>>A>>B>>C;
  std::cout <<( (A+B==C||A+C==B||B+C==A)? "Yes":"No");
}