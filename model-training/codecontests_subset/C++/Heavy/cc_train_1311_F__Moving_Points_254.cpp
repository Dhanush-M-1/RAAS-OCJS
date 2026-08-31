#include <bits/stdc++.h>
using namespace std;
long long ans, n, a1[202020], a2[202020], od[202020];
pair<long long, long long> p[202020];
map<long long, long long> mp;
void gx1(long long x, long long v) {
  for (long long i = x; i < 200200; i += i & -i) {
    a1[i] += v;
  }
}
void gx2(long long x, long long v) {
  for (long long i = x; i < 200200; i += i & -i) {
    a2[i] += v;
  }
}
long long gt1(long long p) {
  long long rt = 0;
  for (long long i = p; i > 0; i -= i & -i) {
    rt += a1[i];
  }
  return rt;
}
long long gt2(long long p) {
  long long rt = 0;
  for (long long i = p; i > 0; i -= i & -i) {
    rt += a2[i];
  }
  return rt;
}
signed main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> p[i].first;
  }
  for (long long i = 1; i <= n; i++) {
    cin >> p[i].second;
    od[i] = p[i].second;
  }
  sort(od + 1, od + n + 1);
  sort(p + 1, p + n + 1);
  long long pp = 1;
  for (long long i = 1; i <= n; i++) {
    if (!mp[od[i]]) {
      mp[od[i]] = pp;
      pp++;
    }
  }
  for (long long i = 1; i <= n; i++) {
    ans += p[i].first * gt1(mp[p[i].second]) - gt2(mp[p[i].second]);
    gx1(mp[p[i].second], 1ll);
    gx2(mp[p[i].second], p[i].first);
  }
  cout << ans << endl;
  return 0;
}
