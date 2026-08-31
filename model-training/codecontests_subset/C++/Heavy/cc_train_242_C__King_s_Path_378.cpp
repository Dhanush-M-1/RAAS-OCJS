#include <bits/stdc++.h>
using namespace std;
mt19937 rnd(time(0));
const double eps = 1e-10;
const long long inf = 0x3f3f3f3f3f3f3f3fLL;
const long long N = 2e5 + 5;
const long long MOD = 1e9 + 7;
long long pw(long long b, long long p) {
  b %= MOD;
  long long res = 1;
  while (p > 0) {
    if (p & 1) res = res * b % MOD;
    b = b * b % MOD;
    p >>= 1;
  }
  return res;
}
set<pair<long long, long long>> s;
map<pair<long long, long long>, long long> d;
int32_t main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long n, x0, y0, x1, y1, r, p, q;
  cin >> x0 >> y0 >> x1 >> y1 >> n;
  for (long long i = 0; i < n; i++) {
    cin >> r >> p >> q;
    for (long long j = p; j <= q; j++) {
      s.insert(make_pair(r, j));
    }
  }
  queue<pair<long long, long long>> Q;
  Q.push(make_pair(x0, y0));
  d[make_pair(x0, y0)] = 0;
  while (!Q.empty()) {
    long long x = Q.front().first;
    long long y = Q.front().second;
    long long dist = d[make_pair(x, y)];
    Q.pop();
    for (long long i = -1; i <= 1; i++) {
      for (long long j = -1; j <= 1; j++) {
        pair<long long, long long> cur = make_pair(x + i, y + j);
        if (d.count(cur) || !s.count(cur)) continue;
        Q.push(cur);
        d[cur] = dist + 1;
      }
    }
  }
  if (!d.count(make_pair(x1, y1)))
    cout << -1;
  else
    cout << d[make_pair(x1, y1)];
  return 0;
}
