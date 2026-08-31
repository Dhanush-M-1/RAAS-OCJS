#include <bits/stdc++.h>

using namespace std;
#define rep(i,n) for(int i=0;i<n;i++)
#define ll long long int
#define INF 1000000007
// cin.eof() 入力個数の問題
int main(){
int n,m;
cin>>n>>m;
ll a[n],b[n],c[m],d[m];
rep(i,n){
    cin>>a[i]>>b[i];
}
rep(i,m){
    cin>>c[i]>>d[i];
}
rep(i,n){
    ll point=INF;
    int ans=0;
    rep(k,m){
ll A=abs(a[i]-c[k])+abs(b[i]-d[k]);
if(point>A){
    point=A;
ans=k+1;
}
    }
    cout<<ans<<endl;
}

  return 0;
}
