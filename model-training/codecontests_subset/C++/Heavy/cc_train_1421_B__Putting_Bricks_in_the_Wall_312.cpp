#include <bits/stdc++.h>
const long long INF = 1e18;
const long long mod = 1e9 + 7;
using namespace std;
void solve() {
  long long n;
  cin >> n;
  vector<vector<char>> vec(n, vector<char>(n));
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < n; j++) {
      cin >> vec[i][j];
    }
  }
  long long a = vec[0][1];
  long long b = vec[1][0];
  long long c = vec[n - 1][n - 2];
  long long d = vec[n - 2][n - 1];
  vector<pair<long long, long long>> ans;
  if (c == d) {
    if (a == c) ans.push_back({0, 1});
    if (b == c) ans.push_back({1, 0});
  } else if (a == b) {
    if (a == c) ans.push_back({n - 1, n - 2});
    if (a == d) ans.push_back({n - 2, n - 1});
  } else {
    ans.push_back({1, 0});
    if (a == c) ans.push_back({n - 1, n - 2});
    if (a == d) ans.push_back({n - 2, n - 1});
  }
  cout << ans.size() << endl;
  for (auto p : ans) {
    cout << p.first + 1 << " " << p.second + 1 << endl;
  }
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long tests = 1;
  cin >> tests;
  while (tests--) {
    solve();
  }
  return 0;
}
