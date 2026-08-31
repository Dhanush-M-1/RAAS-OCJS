#include<bits/stdc++.h>
#define rep(i, n) for (int64_t i = 0; i < (int64_t)(n); i++)
using namespace std;


int main(){
  int n,m;cin>>n>>m;
  int a[n],b[n],c[m],d[m];
  rep(i,n)cin>>a[i]>>b[i];
  rep(i,m)cin>>c[i]>>d[i];
  int ans;
  rep(i,n){
    int mn=1e9;
    rep(j,m){
      int dst=abs(c[j]-a[i])+abs(d[j]-b[i]);
      if(dst<mn){
        mn=dst;
        ans=j+1;
      }
    }
    cout<<ans<<endl;
  }
}