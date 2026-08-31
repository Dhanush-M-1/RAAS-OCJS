#include <iostream>
 
using namespace std;
 
int main(){
  int a,b;
  cin>>a>>b;
  cout<<((a%2==0||b%2==0)?"Even":"Odd");
  return 0;
}
