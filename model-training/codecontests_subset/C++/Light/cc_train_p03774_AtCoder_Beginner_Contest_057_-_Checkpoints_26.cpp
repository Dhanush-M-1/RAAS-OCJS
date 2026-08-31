#include <bits/stdc++.h>
#define rep(i,a,n) for (int i = a; i < (int)(n); i++)
using namespace std;

int main() {
  int N,M; cin >> N >> M; int a[N],b[N],c[M],d[M]; 
  rep(i,0,N) cin >> a[i] >> b[i];
  rep(i,0,M) cin >> c[i] >> d[i];
  
  rep(i,0,N) {
    int ans = abs(a[i]-c[0])+abs(b[i]-d[0]), point =1;
    rep(j,0,M) {
      int tmp = abs(a[i]-c[j])+abs(b[i]-d[j]);
      if (ans > tmp) {
        ans = tmp; point = j+1;
      }
    }
    cout << point << endl;
  }
}