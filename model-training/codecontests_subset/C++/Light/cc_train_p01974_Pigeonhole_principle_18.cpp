#include <bits/stdc++.h>
typedef long long LL;
#define FOR(i,a,b) for(int i=(a);i<(b);++i)
#define REP(i,n) FOR(i,0,n)

using namespace std;

int main(void)
{
  int n;
  cin >> n;
  vector<int> a(n);
  REP(i,n) cin >> a[i];
  REP(i,n) REP(j,i) {
    if ((a[j]-a[i])%(n-1)) continue;
    cout << a[j] << ' ' << a[i] << endl;
    return 0;
  }
  return 0;
}

