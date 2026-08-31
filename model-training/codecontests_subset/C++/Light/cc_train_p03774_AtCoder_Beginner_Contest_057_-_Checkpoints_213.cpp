#include <bits/stdc++.h>
#define FOR(i,x,y) for(int i=x;i<y;i++)
using namespace std;
int main(){
  int a[100],b[100],c[100],d[100],N,M;
  cin >> N >> M;
  FOR(i,0,N)cin >> a[i] >> b[i];
  FOR(i,0,M)cin >> c[i] >> d[i];
  FOR(i,0,N){
    int ma = 1e9,ans;
    FOR(j,0,M){
      if(ma > abs(a[i]-c[j])+abs(b[i]-d[j])){
        ans = j;
        ma = abs(a[i]-c[j])+abs(b[i]-d[j]);
      }
    }
    cout << ans+1 << endl;
  }
}
