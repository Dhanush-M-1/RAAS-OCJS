#include <bits/stdc++.h>
using namespace std;
using ll = int64_t;
using ld = long double;
void solve();
bool comp(const pair<int64_t, int64_t> &a, const pair<int64_t, int64_t> &b) {
  if (a.first != b.first) return (a.first < b.first);
  return (a.second > b.second);
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cout.tie(0);
  cin.tie(0);
  solve();
  return 0;
}
void solve() {
  int64_t n;
  cin >> n;
  pair<int64_t, int64_t> a[n];
  for (int64_t i = 0; i < n; i++) {
    cin >> a[i].first;
    a[i].second = i;
  }
  sort(a, a + n, comp);
  int64_t q;
  cin >> q;
  while (q--) {
    int64_t x, y;
    cin >> x >> y;
    vector<pair<int64_t, int64_t>> v;
    for (int64_t i = n - 1; i >= n - x; i--) {
      v.push_back({a[i].second, a[i].first});
    }
    sort((v).begin(), (v).end());
    cout << v[y - 1].second << endl;
  }
}
