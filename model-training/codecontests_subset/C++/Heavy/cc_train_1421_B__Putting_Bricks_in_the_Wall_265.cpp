#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n;
  cin >> n;
  char a[n][n];
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < n; j++) cin >> a[i][j];
  }
  vector<pair<long long, long long>> v;
  if (a[0][1] == a[1][0]) {
    if (a[n - 2][n - 1] == a[0][1]) v.push_back({n - 1, n});
    if (a[n - 1][n - 2] == a[0][1]) v.push_back({n, n - 1});
  } else {
    if (a[n - 2][n - 1] == a[n - 1][n - 2]) {
      if (a[n - 2][n - 1] == '0') {
        if (a[1][0] == '0')
          v.push_back({2, 1});
        else
          v.push_back({1, 2});
      } else {
        if (a[1][0] == '1')
          v.push_back({2, 1});
        else
          v.push_back({1, 2});
      }
    } else {
      if (a[1][0] == '1')
        v.push_back({2, 1});
      else
        v.push_back({1, 2});
      if (a[n - 2][n - 1] == '0')
        v.push_back({n - 1, n});
      else if (a[n - 1][n - 2] == '0')
        v.push_back({n, n - 1});
    }
  }
  cout << v.size() << "\n";
  for (long long i = 0; i < v.size(); i++)
    cout << v[i].first << " " << v[i].second << "\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
}
