#include<iostream>
using namespace std;
int main(){
int a,b,c;
  cin>>a>>b>>c;
  if(max(a,b)<c) swap(c,b);
  if(a<b) a+=c;
  else b+=c;
  cout<<(a==b?"Yes":"No")<<endl;
}