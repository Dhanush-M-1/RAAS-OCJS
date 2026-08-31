#include<bits/stdc++.h>
#define REP(i,n) for(int i=0; i<n; i++)
using namespace std;
int main(){
  long long int ind,N,M,a[101],b[101],c[101],d[101],m;
  cin >> N >> M;
  REP(i,N) cin >> a[i] >> b[i];
  REP(i,M) cin >> c[i] >> d[i];
  REP(i,N){
    m = 9.0E8+1;
    int ans = -1;
    REP(j,M){
      if(m > abs(a[i]-c[j]) + abs(b[i]-d[j])){
        m = abs(a[i]-c[j]) + abs(b[i]-d[j]);
        ans = j+1;
      }
    }
    cout << ans << endl;
  }
  return 0;
}
