#include <bits/stdc++.h>
using namespace std;

int main(){
  int N,M;
  cin>>N>>M;
  vector<int64_t> a(N),b(N),c(M),d(M);
  for(int i=0;i<N;++i) cin>>a[i]>>b[i];
  for(int i=0;i<M;++i) cin>>c[i]>>d[i];

  for(int i=0;i<N;++i){
    int64_t ch=1e15;
    int res;
    for(int j=0;j<M;++j){
      if(ch>abs(a[i]-c[j])+abs(b[i]-d[j])){
      res=j+1;
      ch=abs(a[i]-c[j])+abs(b[i]-d[j]);
      }
    }
    cout<<res<<endl;
  }
}