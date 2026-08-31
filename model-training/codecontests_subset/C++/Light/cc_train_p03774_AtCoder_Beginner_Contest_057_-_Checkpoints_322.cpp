#include <bits/stdc++.h>
using namespace std;
#define rep(i,n) for (int i = 0; i < (n); i++) 
#define all(v) begin(v),end(v)
using ll = long long;

int main() {
  int n,m;cin>>n>>m;
  vector<int> a(n),b(n),c(m),d(m);
  rep(i,n)cin>>a[i]>>b[i];
  rep(i,m)cin>>c[i]>>d[i];
  rep(i,n){
    int cnt=0,ans=1e9;
    rep(j,m){
      int e=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(e<ans){
        cnt=j+1;
        ans=e;
      }
    }
    cout<<cnt<<endl;
  }
}