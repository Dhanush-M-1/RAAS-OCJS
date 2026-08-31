#include<iostream>
using namespace std;

int main(){
  int a,b;
  cin>>a>>b;
  if(1<=a && a<=9 && 1<=b && b<=9) cout<<a*b;
  else cout<<-1;
}