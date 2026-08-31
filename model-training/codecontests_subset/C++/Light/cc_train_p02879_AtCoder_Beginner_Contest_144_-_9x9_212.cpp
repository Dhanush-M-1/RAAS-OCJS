#include<iostream>
int main(){
  int a,b;
  std::cin>>a>>b;
  if(a<10&&b<10)std::cout<<a*b;
  else std::cout<<-1;
}