#include <bits/stdc++.h>
#pragma comment(linker, "/stack:200000000")
#pragma GCC optimize("Ofast")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
using namespace std;
set<long long> g[300003];
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long n, m;
  cin >> n >> m;
  long long p[n + 1], i, j;
  for (i = 1; i <= n; ++i) cin >> p[i];
  long long x, y;
  for (i = 1; i <= m; ++i) {
    cin >> x >> y;
    g[x].insert(y);
  }
  list<long long> v;
  v.clear();
  long long ans = 0;
  for (i = n - 1; i >= 1; --i) {
    if (g[p[i]].find(p[n]) == g[p[i]].end()) {
      v.push_front(p[i]);
      continue;
    } else {
      long long f = 0;
      for (auto it : v) {
        if (g[p[i]].find(it) == g[p[i]].end()) {
          f = 1;
          break;
        }
      }
      if (f == 1)
        v.push_front(p[i]);
      else
        ++ans;
    }
  }
  cout << ans;
  return 0;
}
