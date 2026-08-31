#include<iostream>
using namespace std;
int main(){
  int a,b;
  cin>>a>>b;
  if(a >= 1 && a<=9 && b<=9 && b >= 1)cout<<a*b;
  else cout<<-1;
}