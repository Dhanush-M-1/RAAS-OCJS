#include<bits/stdc++.h>
using namespace std;
void f(string s,int n,char c) {
  char b;
  if (n==0) cout<<s<<endl;
  else {
    for (b='a';b<=c;b++) {
      if (b==c) f(s+b,n-1,c+1);
      else f(s+b,n-1,c);
    }
  }
}
int main() {
  int n;
  cin>>n;
  f("",n,'a');
}