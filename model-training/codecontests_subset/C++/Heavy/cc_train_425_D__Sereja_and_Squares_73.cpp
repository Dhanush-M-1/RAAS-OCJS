#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
#pragma GCC optimize("unroll-loops")
using namespace std;
const long long N = 1e5 + 10;
unordered_set<long long> xx[N];
unordered_set<long long> yy[N];
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  long long x[n + 1], y[n + 1];
  for (long long i = 0; i < n; i++) {
    cin >> x[i] >> y[i];
    xx[x[i]].insert(y[i]);
    yy[y[i]].insert(x[i]);
  }
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    if (xx[x[i]].size() < yy[y[i]].size()) {
      for (auto to : xx[x[i]])
        if (to != y[i]) {
          long long len = abs(y[i] - to);
          long long xU = x[i] - len;
          long long xD = x[i] + len;
          if (xU >= 0) {
            if (yy[y[i]].find(xU) != yy[y[i]].end() &&
                yy[to].find(xU) != yy[to].end())
              ans++;
          }
          if (yy[y[i]].find(xD) != yy[y[i]].end() &&
              yy[to].find(xD) != yy[to].end())
            ans++;
        }
    } else {
      for (auto to : yy[y[i]])
        if (to != x[i]) {
          long long len = abs(x[i] - to);
          long long xU = y[i] - len;
          long long xD = y[i] + len;
          if (xU >= 0) {
            if (xx[x[i]].find(xU) != xx[x[i]].end() &&
                xx[to].find(xU) != xx[to].end())
              ans++;
          }
          if (xx[x[i]].find(xD) != xx[x[i]].end() &&
              xx[to].find(xD) != xx[to].end())
            ans++;
        }
    }
  }
  cout << ans / 4 << endl;
  return 0;
}
