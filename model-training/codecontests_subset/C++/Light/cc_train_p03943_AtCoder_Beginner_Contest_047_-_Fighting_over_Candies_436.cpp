#include <bits/stdc++.h>
using namespace std;

int main() {
  int A,B,C;
  cin>>A>>B>>C;
  if(max({A,B,C})*2==A+B+C) cout<<"Yes"<<endl;
  else cout<<"No"<<endl;
}