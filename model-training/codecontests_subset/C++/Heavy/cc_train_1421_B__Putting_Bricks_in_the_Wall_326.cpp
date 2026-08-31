#include <bits/stdc++.h>
using namespace std;
const long long int mod = 1e9 + 7;
const long long int inf = 2e9 + 5;
double PI = 3.14159265358979323846;
void solve() {
  int n;
  cin >> n;
  char c[n][n];
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < n; j++) {
      cin >> c[i][j];
    }
  }
  vector<pair<int, int> > ans;
  if (c[0][1] == c[1][0]) {
    int x = c[0][1] - '0';
    x = 1 - x;
    if (c[n - 1][n - 2] != '0' + x) {
      ans.push_back({n - 1, n - 2});
    }
    if (c[n - 2][n - 1] != '0' + x) {
      ans.push_back({n - 2, n - 1});
    }
  } else if (c[n - 1][n - 2] == c[n - 2][n - 1]) {
    int x = c[n - 1][n - 2] - '0';
    x = 1 - x;
    if (c[0][1] != '0' + x) {
      ans.push_back({0, 1});
    }
    if (c[1][0] != '0' + x) {
      ans.push_back({1, 0});
    }
  } else {
    int x = c[0][1] - '0';
    x = 1 - x;
    ans.push_back({1, 0});
    if (c[n - 1][n - 2] != '0' + x) {
      ans.push_back({n - 1, n - 2});
    }
    if (c[n - 2][n - 1] != '0' + x) {
      ans.push_back({n - 2, n - 1});
    }
  }
  cout << ans.size() << "\n";
  for (auto p : ans) {
    cout << p.first + 1 << " " << p.second + 1 << "\n";
  }
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int T;
  cin >> T;
  while (T--) solve();
  return 0;
}
