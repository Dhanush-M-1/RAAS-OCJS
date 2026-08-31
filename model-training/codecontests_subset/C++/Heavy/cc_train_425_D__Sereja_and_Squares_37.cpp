#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
long long powm(long long a, long long b, long long m);
const long long N = 1e5 + 1;
unordered_set<long long> xx[100001];
vector<long long> x[100001], y[100001];
vector<pair<long long, long long> > points;
signed main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  long long n;
  cin >> n;
  long long tex, tey;
  for (long long i = 0; i < n; i++) {
    cin >> tex >> tey;
    points.push_back({tex, tey});
    xx[tex].insert(tey);
    x[tex].push_back(tey);
    y[tey].push_back(tex);
  }
  long long ans = 0;
  for (pair<long long, long long> te : points)
    if (y[te.second].size() > x[te.first].size()) {
      for (long long j : x[te.first])
        if (te.first + j - te.second >= 0 && te.first + j - te.second <= 100000)
          if (xx[te.first + j - te.second].count(te.second) &&
              xx[te.first + j - te.second].count(j))
            ans++;
    } else
      for (long long j : y[te.second])
        if (xx[te.first].count(te.second - te.first + j) &&
            xx[j].count(te.second + j - te.first))
          ans++;
  ans -= n;
  ans /= 2;
  cout << ans << '\n';
}
long long powm(long long a, long long b, long long m) {
  long long te = 1;
  while (b) {
    if (b & 1) te = (te * a) % m;
    a = (a * a) % m;
    b >>= 1;
  }
  return te;
}
