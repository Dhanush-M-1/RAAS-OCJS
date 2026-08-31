#include<bits/stdc++.h>
#define rep(i,n) for(int i=0;i<(n);++i)
using namespace std;

int main(){
  int n,m;cin >> n >> m;
  int a[n],b[n];rep(i,n)cin >> a[i] >> b[i];
  int c[m],d[m];rep(i,m)cin >> c[i] >> d[i];
  for(int i=0;i<n;++i){
    long long an = 100000000000;
    int ans = 0;
    for(int j=0;j<m;++j){
      int m = abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(m < an){ans = j+1;an = m;}
    }
    cout << ans << endl;
  }
  return 0;
}
