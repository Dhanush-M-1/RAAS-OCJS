#include <bits/stdc++.h>
#define rep(i,n) for(int i=0; i<(int)(n); i++)

using namespace std;
typedef long long LL;
const int INF=1000000000;

int main(){
  int N, M;
  cin >> N >> M;
  vector<int> a(N), b(N), c(M), d(M);
  rep(i,N) cin >> a[i] >> b[i];
  rep(i,M) cin >> c[i] >> d[i];
  rep(i,N){
    int dist=INF, ans=0;
    rep(j,M){
      int D=abs(a[i]-c[j])+abs(b[i]-d[j]);
      if(dist>D) dist=D, ans=j+1;
    }
    cout << ans << endl;
  }

  return 0;
}
