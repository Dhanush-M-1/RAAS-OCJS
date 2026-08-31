#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n;
    cin >> n;
    char s[n + 1][n + 1];
    for (int i = 1; i <= n; ++i) cin >> s[i] + 1;
    vector<pair<int, int>> ans;
    if (s[1][2] == s[2][1]) {
      if (s[n][n - 1] == s[1][2]) ans.push_back(pair<int, int>(n, n - 1));
      if (s[n - 1][n] == s[1][2]) ans.push_back(pair<int, int>(n - 1, n));
    } else if (s[n][n - 1] == s[n - 1][n]) {
      if (s[n][n - 1] == s[1][2]) ans.push_back(pair<int, int>(1, 2));
      if (s[n - 1][n] == s[2][1]) ans.push_back(pair<int, int>(2, 1));
    } else {
      if (s[1][2] == '1')
        ans.push_back(pair<int, int>(1, 2));
      else
        ans.push_back(pair<int, int>(2, 1));
      if (s[n][n - 1] == '0')
        ans.push_back(pair<int, int>(n, n - 1));
      else
        ans.push_back(pair<int, int>(n - 1, n));
    }
    cout << ans.size() << '\n';
    for (auto x : ans) cout << x.first << " " << x.second << '\n';
  }
  return 0;
}
