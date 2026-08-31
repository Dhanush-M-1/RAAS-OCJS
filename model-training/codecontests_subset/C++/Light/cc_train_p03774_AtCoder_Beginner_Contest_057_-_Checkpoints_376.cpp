#include<bits/stdc++.h>
using namespace std;
typedef long long ll;
#define fr(i,n) for(int i=0;i++<n;)
ll INF=1e9;

int main(){
  ll n,m,a[55],b[55],c[55],d[55],e[55][55],f[55];
  cin>>n>>m;
  fr(i,n) cin>>a[i]>>b[i];
  fr(i,m) cin>>c[i]>>d[i];
  fr(i,n) f[i]=INF;
  fr(i,n){
    fr(j,m){
      e[i][j]=abs(a[i]-c[j])+abs(b[i]-d[j]);
      f[i]=min(f[i],e[i][j]);
    }
  }
  fr(i,n){
    fr(j,m){
      if(e[i][j]==f[i]){
        cout<<j<<endl;
        break;
      }
    }
  }
}