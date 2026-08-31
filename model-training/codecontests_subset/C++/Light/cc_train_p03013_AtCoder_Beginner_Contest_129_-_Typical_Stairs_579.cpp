#include <bits/stdc++.h>
using namespace std;

int main(){
  int n,m; cin>>n>>m;
  set<int> a;
  for(int i=0; i<m; ++i){int b; cin>>b; a.insert(b);}

  long long b=1, c=0, d=0;
  if(a.find(1)==a.end())c=1;
  for(int i=2; i<=n; ++i){
    if(a.find(i)!=a.end())d=0;
    else d=(c+b)%(1000000007);

    b=c; c=d;
  }
  cout<<c<<endl;
}
