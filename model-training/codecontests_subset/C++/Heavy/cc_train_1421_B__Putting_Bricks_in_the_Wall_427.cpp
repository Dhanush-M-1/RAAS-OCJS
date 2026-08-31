#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  cin >> t;
  while (t--) {
    int n, m, i, x = 0, y, z;
    cin >> n;
    string s[n + 1];
    for (int i = 0; i < n; i++) cin >> s[i];
    vector<pair<int, int>> v;
    if (s[0][1] == s[1][0]) {
      if (s[n - 1][n - 2] == s[0][1]) {
        v.push_back({n, n - 1});
      }
      if (s[n - 2][n - 1] == s[0][1]) {
        v.push_back({n - 1, n});
      }
    } else if (s[n - 1][n - 2] == s[n - 2][n - 1]) {
      if (s[n - 1][n - 2] == s[0][1]) {
        v.push_back({1, 2});
      }
      if (s[n - 2][n - 1] == s[1][0]) {
        v.push_back({2, 1});
      }
    } else {
      if (s[0][1] != '0') {
        v.push_back({1, 2});
      }
      if (s[1][0] != '0') {
        v.push_back({2, 1});
      }
      if (s[n - 2][n - 1] != '1') {
        v.push_back({n - 1, n});
      }
      if (s[n - 1][n - 2] != '1') {
        v.push_back({n, n - 1});
      }
    }
    cout << v.size() << endl;
    for (int i = 0; i < v.size(); i++) {
      cout << v[i].first << " " << v[i].second << endl;
    }
  }
  return 0;
}
