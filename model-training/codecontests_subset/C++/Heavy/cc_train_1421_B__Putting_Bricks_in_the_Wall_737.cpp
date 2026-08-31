#include <bits/stdc++.h>
using namespace std;
void fastio() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
}
void one();
int main() {
  fastio();
  int t = 1;
  cin >> t;
  for (int i = 0; i < t; ++i) {
    one();
  }
  return 0;
}
void one() {
  int n;
  cin >> n;
  vector<string> s;
  for (int i = 0; i < n; ++i) {
    string ss;
    cin >> ss;
    s.push_back(ss);
  }
  vector<pair<int, int>> ans;
  if (s[0][1] == s[1][0]) {
    auto c = s[0][1];
    if (s[n - 1][n - 2] == c) ans.push_back({n - 1, n - 2});
    if (s[n - 2][n - 1] == c) ans.push_back({n - 2, n - 1});
  } else if (s[0][1] != s[1][0]) {
    if (s[n - 1][n - 2] == s[n - 2][n - 1]) {
      char c = s[n - 1][n - 2];
      if (s[0][1] == c) {
        ans.push_back({0, 1});
      } else {
        ans.push_back({1, 0});
      }
    } else {
      ans.push_back({0, 1});
      if (s[0][1] != s[n - 1][n - 2]) {
        ans.push_back({n - 1, n - 2});
      } else {
        ans.push_back({n - 2, n - 1});
      }
    }
  }
  cout << ans.size() << "\n";
  for (auto p : ans) {
    cout << p.first + 1 << " " << p.second + 1 << "\n";
  }
}
