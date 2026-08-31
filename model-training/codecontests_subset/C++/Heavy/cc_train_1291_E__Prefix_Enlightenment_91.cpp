#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long n, k, pa[600010], ct[600010], siz[600010], ans = 0;
vector<long long> g[300010];
string s;
long long find(long long x) {
  if (x == pa[x]) return x;
  pa[x] = find(pa[x]);
  return pa[x];
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k;
  cin >> s;
  for (long long i = 0; i < k; i++) {
    long long t;
    cin >> t;
    for (long long j = 0; j < t; j++) {
      long long x;
      cin >> x;
      --x;
      g[x].push_back(i);
    }
  }
  for (long long i = 0; i < k; i++) {
    ct[2 * i + 1] = 1;
    ct[2 * i] = 0;
    pa[2 * i] = 2 * i;
    pa[2 * i + 1] = 2 * i + 1;
    siz[2 * i + 1] = 1;
    siz[2 * i] = 1;
  }
  for (long long i = 0; i < n; i++) {
    long long a, b;
    ;
    if (((long long)g[i].size()) == 2) {
      a = g[i][0];
      b = g[i][1];
      ;
      ;
      long long x1 = find(2 * a), y1 = find(b * 2), x2 = find(2 * a + 1),
                y2 = find(2 * b + 1);
      if (s[i] == '0') swap(x1, x2);
      ;
      ;
      if (x1 == y1) {
        cout << ans << '\n';
        continue;
      }
      ans -= (min(ct[x1], ct[x2]) + min(ct[y1], ct[y2]));
      ;
      if (siz[x1] > siz[y1]) swap(x1, y1), swap(x2, y2);
      siz[y1] += siz[x1];
      pa[x1] = y1;
      ct[y1] += ct[x1];
      ct[x1] = 0;
      siz[y2] += siz[x2];
      pa[x2] = y2;
      ct[y2] += ct[x2];
      ct[x2] = 0;
      ans += min(ct[y1], ct[y2]);
    } else {
      if (((long long)g[i].size()) == 0) {
        cout << ans << '\n';
        continue;
      }
      long long a = g[i][0], x, delx;
      if (s[i] == '1')
        x = find(2 * a), delx = find(2 * a + 1);
      else
        x = find(2 * a + 1), delx = find(2 * a);
      ans -= min(ct[x], ct[delx]);
      ;
      ct[delx] = 1e10;
      ans += ct[x];
    }
    cout << ans << '\n';
  }
  return 0;
}
