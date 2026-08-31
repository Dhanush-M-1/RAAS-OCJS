#include <bits/stdc++.h>
using namespace std;
template <typename G1, typename G2 = G1, typename G3 = G1>
struct triple {
  G1 first;
  G2 second;
  G3 T, Fo;
};
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int n, m;
  cin >> n >> m;
  vector<long long> mx(n, 1e9);
  vector<long long> s(n);
  vector<triple<long long> > queries;
  for (int i = 0; i < m; i++) {
    long long t, l, r, x;
    cin >> t >> l >> r >> x;
    --l;
    --r;
    queries.push_back({t, l, r, x});
    if (t == 1) {
      for (int j = l; j <= r; j++) s[j] += x;
    } else {
      for (int j = l; j <= r; j++) mx[j] = min(mx[j], x - s[j]);
    }
  }
  vector<long long> ans = mx;
  bool ok = true;
  for (int i = 0; i < m; i++) {
    long long t = queries[i].first;
    long long l = queries[i].second;
    long long r = queries[i].T;
    long long x = queries[i].Fo;
    if (t == 1) {
      for (int j = l; j <= r; j++) mx[j] += x;
    } else {
      long long temp = -1e9;
      for (int j = l; j <= r; j++) temp = max(mx[j], temp);
      ok &= temp == x;
    }
  }
  if (!ok)
    cout << "NO\n";
  else {
    cout << "YES\n";
    for (int i = 0; i < n; i++) cout << ans[i] << " \n"[i == n - 1];
  }
  return 0;
}
