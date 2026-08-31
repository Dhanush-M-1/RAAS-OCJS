#include<bits/stdc++.h>
using namespace std;
void f(string s,char m,int n){
  if(!n)cout<<s<<"\n";
  else{
    for(char c='a';c<m;++c) f(s+c,m,n-1);
    f(s+m,m+1,n-1);
  }
}
int main(){
  int n;
  cin>>n;
  f("a",'b',n-1);
}