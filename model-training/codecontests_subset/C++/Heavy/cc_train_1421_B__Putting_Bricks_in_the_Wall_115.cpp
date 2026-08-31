#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n;
  string s;
  vector<string> v;
  cin >> n;
  for (int i = (0); i < int(n); i++) {
    cin >> s;
    v.push_back(s);
  }
  vector<pair<int, int> > ans;
  if (v[0][1] == v[1][0]) {
    if (v[n - 1][n - 2] == v[0][1]) ans.push_back({n - 1, n - 2});
    if (v[n - 2][n - 1] == v[0][1]) ans.push_back({n - 2, n - 1});
  } else if (v[n - 1][n - 2] == v[n - 2][n - 1]) {
    if (v[0][1] == v[n - 1][n - 2]) ans.push_back({0, 1});
    if (v[1][0] == v[n - 1][n - 2]) ans.push_back({1, 0});
  } else {
    ans.push_back({0, 1});
    v[0][1] = v[1][0];
    if (v[n - 1][n - 2] == v[0][1]) ans.push_back({n - 1, n - 2});
    if (v[n - 2][n - 1] == v[0][1]) ans.push_back({n - 2, n - 1});
  }
  cout << ans.size() << endl;
  for (auto t : ans) cout << t.first + 1 << ' ' << t.second + 1 << endl;
}
int main() {
  int t;
  cin >> t;
  for (int i = (0); i < int(t); i++) solve();
  return 0;
}
